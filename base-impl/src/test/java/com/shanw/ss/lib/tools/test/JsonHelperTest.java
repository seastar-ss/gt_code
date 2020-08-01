package com.shanw.ss.lib.tools.test;

import com.google.gson.*;
import com.shawn.ss.lib.tools.CollectionHelper;
import com.shawn.ss.lib.tools.JSONHelper;
import org.junit.Test;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * Created by ss on 2017/11/27.
 */
public class JsonHelperTest {

    @Test
    public void testToJson(){
        String s = JSONHelper.toJson(CollectionHelper.mapBuilder().put("a", "b").put("what", "test").getMap());
        System.out.println(s);
    }




    static Gson gson =new GsonBuilder().registerTypeHierarchyAdapter(BaseRs.class,new ResultDeserializer()).create();

    public static class ResultDeserializer implements JsonDeserializer<BaseRs> {
        public static Gson gson=new Gson();
        @Override
        public BaseRs deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            if(!json.isJsonObject()){
                throw new IllegalArgumentException("json 错误");
            }
            if(!(typeOfT instanceof Class)){
                throw new IllegalArgumentException("类型 错误");
            }
            Class c=(Class)typeOfT;
            JsonObject object = json.getAsJsonObject();
            JsonPrimitive rsObj = object.getAsJsonPrimitive("rs");
            int rs=rsObj.getAsInt();

            if(rs!=0) {
                JsonElement rsmObj = object.get("resultMessage");
                if(rsmObj.isJsonPrimitive()){
                    String str = rsmObj.getAsString();

                    TypeVariable[] parameters = c.getTypeParameters();
                    if(parameters==null ||parameters.length==0){

                    }else{

                    }
                }else {

                }

            }
            return null;
        }
    }


    static abstract class BaseRs<T>{
        int rs;
        String msg;
        T resultMessage;

        public int getRs() {
            return rs;
        }

        public void setRs(int rs) {
            this.rs = rs;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public T getResultMessage() {
            return resultMessage;
        }

        public void setResultMessage(T resultMessage) {
            this.resultMessage = resultMessage;
        }
    }
    public static class COM{
        String name;
        String port;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPort() {
            return port;
        }

        public void setPort(String port) {
            this.port = port;
        }
    }

    public static class COMRS extends BaseRs<COM>{}

    @Test
    public void testGson(){
        String json="{\"rs\":1,\"msg\":\"test\",\"resultMessage\":\"\"}";
        final COMRS comrs = gson.fromJson(json, COMRS.class);
    }
}
