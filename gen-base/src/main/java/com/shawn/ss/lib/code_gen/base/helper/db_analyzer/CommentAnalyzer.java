package com.shawn.ss.lib.code_gen.base.helper.db_analyzer;

import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.StringHelper;
//import com.shawn.ss.lib.tools.data_store.api.interfaces.db_operation.dao.model.ColumnInfo;
import com.shawn.ss.lib.tools.db.api.interfaces.db_operation.dao.model.EnumTypeDef;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommentAnalyzer {

    private static final String CODE_PREFIX = "@@";
    private static final String BLOCK_END = "--";


    public static class EnumTypeDefInternal extends EnumTypeDef{
        transient int state=0;
        transient EnumTypeDef.EnumDef current;
        transient StringBuilder currentRemarkBuilder;
        transient StringBuilder currentItemComment;

        public int getState() {
            return state;
        }

        public EnumTypeDefInternal setState(int state) {
            this.state = state;
            return this;
        }

        public EnumDef getCurrent() {
            return current;
        }

        public EnumTypeDefInternal setCurrent(EnumDef current) {
            this.current = current;
            return this;
        }
    }

    public interface CommentHandler {
        Object handle(String text, CommentInfoHandler info, Object data);

        CommentHandler transfer(String text, CommentInfoHandler info, Object data);
    }

    public interface CommentInfoHandler {
        Object getInfo(String key,CommentHandler handler);
        void handleResult(Object obj,CommentHandler handler);
    }

    public static class DefaultHandler implements CommentHandler {

        public static final DefaultHandler instance = new DefaultHandler();

        private DefaultHandler() {

        }

        @Override
        public Object handle(String text, CommentInfoHandler info, Object data) {
            StringBuilder ret = null;
            if (data == null || !(data instanceof StringBuilder)) {
                ret = new StringBuilder();
            } else {
                ret = (StringBuilder) data;
            }
            ret.append(text);
            return ret;
        }

        @Override
        public CommentHandler transfer(String text, CommentInfoHandler info, Object data) {
            if (!StringHelper.isEmpty(text) && text.startsWith(CODE_PREFIX)) {
                CommentHandler ret=null;
                for(CommentHandler handler:handlerList){
                    if((ret=handler.transfer(text,info,null))!=this){
                        if(data!=null && data instanceof StringBuilder) {
                            StringBuilder dt=(StringBuilder)data;
                            info.handleResult(dt.toString(),this);
                        }
                        return ret;
                    }
                }
            }
            return this;
        }
    }

    public static class EnumHandler implements CommentHandler {
        static final String ENUM_PREFIX = CODE_PREFIX + "Enum";
        static final Pattern PATTERN_ENUM_HEADER = Pattern.compile("^" + ENUM_PREFIX + "([A-Za-z]+)$");
        static final Pattern PATTERN_ENUM_ITEM = Pattern.compile("^@@(\\w+)\\(([^\\-:]+)\\):(-?\\w+)$");
        static final String ENUM_FOOTER =  ENUM_PREFIX + BLOCK_END;

        public static final EnumHandler instance = new EnumHandler();

        private EnumHandler() {

        }

        @Override
        public EnumTypeDef handle(String text, CommentInfoHandler info, Object data) {
            EnumTypeDefInternal ret=null;
            if(data!=null && data instanceof EnumTypeDefInternal) {
                ret = (EnumTypeDefInternal) data;
            }else {
                ret = new EnumTypeDefInternal();
            }
            Matcher headerMatcher = PATTERN_ENUM_HEADER.matcher(text);
            if(headerMatcher.matches()){
                String clzName = headerMatcher.group(1);
                ret.setClazzName(clzName);
                ret.setState(1);
            }else {
                Matcher matcher = PATTERN_ENUM_ITEM.matcher(text);
                if (matcher.matches()) {
                    if(ret.current!=null && ret.currentItemComment!=null && ret.currentItemComment.length()>0){
                        ret.current.setComment(ret.currentItemComment.toString());
                        ret.currentItemComment.delete(0,ret.currentItemComment.length());
                    }
                    String name = matcher.group(1);
                    String showName = matcher.group(2);
                    String index = matcher.group(3);
                    ret.current=new EnumTypeDef.EnumDef(index,name,showName,null);
                    ret.addItem(ret.current);
                    ret.setState(2);
                }else {
                    if(ret.getState()==1){
                        if(ret.currentRemarkBuilder==null){
                            ret.currentRemarkBuilder=new StringBuilder();
                        }
                        ret.currentRemarkBuilder.append(text);
                    }else if(ret.getState()==2){
                        if(ret.currentItemComment==null){
                            ret.currentItemComment=new StringBuilder();
                        }
                        ret.currentItemComment.append(text);
                    }
                }
            }
            return ret;
        }

        @Override
        public CommentHandler transfer(String text, CommentInfoHandler info, Object data) {
            EnumTypeDefInternal dt=null;
            if(data!=null && data instanceof EnumTypeDefInternal) {
                dt = (EnumTypeDefInternal) data;
            }
            if(text.startsWith(ENUM_PREFIX) ){
                if(text.equals(ENUM_FOOTER)){
                    if(dt!=null){
//                        EnumTypeDef def=(EnumTypeDefInternal)data;
                        if(dt.current!=null && dt.currentItemComment!=null && dt.currentItemComment.length()>0){
                            dt.current.setComment(dt.currentItemComment.toString());
//                            dt.currentItemComment.delete(0,dt.currentItemComment.length());
                        }
                        if(dt.currentRemarkBuilder!=null && dt.currentRemarkBuilder.length()>0){
                            dt.setRemark(dt.currentRemarkBuilder.toString());
                        }
                        dt.setState(0);
                        info.handleResult(dt,this);
                    }
                }else{
                    return this;
                }
            }else if(dt!=null && dt.getState()!=0){
                return this;
            }
            return DefaultHandler.instance;
        }
    }

    public static class EncryptHandler implements CommentHandler {
        static final String ENCRYPT_PREFIX = CODE_PREFIX + "Encrypt";
        static final Pattern PATTERN_ENCRYPT_LINE = Pattern.compile("^" + ENCRYPT_PREFIX + "With(Class|Pass):([A-Za-z0-9_]+)$");
        //static final Pattern PATTERN_ENUM_ITEM = Pattern.compile("^@@(\\w+)\\(([^\\-:]+)\\):(-?\\w+)$");
        static final String ENUM_FOOTER =  ENCRYPT_PREFIX + BLOCK_END;

        @Override
        public Object handle(String text, CommentInfoHandler info, Object data) {
            return null;
        }

        @Override
        public CommentHandler transfer(String text, CommentInfoHandler info, Object data) {
            return null;
        }
    }

    public static List<CommentHandler> handlerList= CollectionHelper.<CommentHandler>listBuilder()
            .add(EnumHandler.instance)
            .getList();
//    public static enum CommentInfoType implements CommentHandler {
//        columnDefault(){
////            {handler=new EnumHandler();}
//            @Override
//            public boolean handle(String text,ColumnInfo info) {
//                return false;
//            }
//
//            @Override
//            public CommentInfoType transfer(String text, ColumnInfo info) {
//                return null;
//            }
//        },
//        columnEnum(){
//            {handler=new EnumHandler();}
//            @Override
//            public boolean handle(String text,ColumnInfo info) {
//                return handler.handle(text,info);
//            }
//
//            @Override
//            public CommentInfoType transfer(String text, ColumnInfo info) {
//                return handler.transfer(text,info);
//            }
//        },
//        columnEncrypt(){
//            @Override
//            public boolean handle(String text,ColumnInfo info) {
//                return true;
//            }
//
//            @Override
//            public CommentInfoType transfer(String text, ColumnInfo info) {
//                return null;
//            }
//        },
//        columnRefer(){
//            @Override
//            public boolean handle(String text,ColumnInfo info) {
//                return true;
//            }
//
//            @Override
//            public CommentInfoType transfer(String text, ColumnInfo info) {
//                return null;
//            }
//        },
//        columnTrigger(){
//            @Override
//            public boolean handle(String text,ColumnInfo info) {
//                return true;
//            }
//
//            @Override
//            public CommentInfoType transfer(String text, ColumnInfo info) {
//                return null;
//            }
//        };
//
//        protected CommentHandler handler;
//    }

    public void analyzeComment(String comment, CommentInfoHandler row) {
//        String comment = row.getComment();

//        if (comment.trim().startsWith(ENUM_PREFIX)) {
        StringBuilder fieldComment = new StringBuilder(), itemComment = new StringBuilder();
        Scanner scanner = new Scanner(comment).useDelimiter("(\r?\n)|;");
        CommentHandler handler = DefaultHandler.instance;
        Object data = null;
//            scanner.skip(ENUM_PREFIX);
        while (scanner.hasNext()) {
            String text = scanner.next();
            if (!StringHelper.isEmpty(text)) {
                text = text.trim();
                handler = handler.transfer(text, row, data);
                data = handler.handle(text, row, data);
            }
        }
//        if(handler instanceof DefaultHandler){
        row.handleResult(data,handler);
//        }
//        Matcher headerMatcher = PATTERN_ENUM_HEADER.matcher(header);
//        if (headerMatcher.matches()) {
//            String clzName = headerMatcher.group(1);
//            int fieldCommentIndex = 0;
//            EnumTypeDef etf = new EnumTypeDef();
//            etf.setClazzName(clzName);
//            while (scanner.hasNext()) {
//                String next = scanner.next();
//
//                Matcher matcher = PATTERN_ENUM_ITEM.matcher(next);
//                if (matcher.matches()) {
//                    String name = matcher.group(1);
//                    String showName = matcher.group(2);
//                    String index = matcher.group(3);
////                    int i = etf.sizeOfItems();
//                    if (fieldCommentIndex > 0) {
//                        EnumTypeDef.EnumDef item = etf.getItem(fieldCommentIndex - 1);
//                        int length = itemComment.length();
//                        if (length > 0) {
//                            item.setComment(itemComment.toString());
//                            itemComment.delete(0, length);
//                        }
//                    }
//                    etf.addItem(index, name, showName, null);
//                    ++fieldCommentIndex;
//                } else {
//                    if (fieldCommentIndex == 0) {
//                        fieldComment.append(next).append("\n");
//                    } else {
//                        itemComment.append(next).append("\n");
//                    }
//                }
//            }
//            if (fieldComment.length() > 0) {
//                etf.setRemark(fieldComment.toString());
//            }
//            if (fieldCommentIndex > 0) {
//                EnumTypeDef.EnumDef item = etf.getItem(fieldCommentIndex - 1);
//                int length = itemComment.length();
//                if (length > 0) {
//                    item.setComment(itemComment.toString());
//                    itemComment.delete(0, length);
//                }
//            }
//            etf.setCol(row);
//            row.setEnumTypeDef(etf);
//        }
    }
}
