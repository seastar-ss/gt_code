package com.shawn.ss.lib.tools.structure;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by ss on 2015/10/28.
 */
public class PoolingOutputStream extends OutputStream {
    public static final int DEFAULT_SIZE = 1024*32;
    static ByteArrayPool pool = ByteArrayPool.getInstance();

    final OutputStream stream;
    final int size;
    final byte[] buffer;
    int index;

    public PoolingOutputStream(OutputStream stream, int size) {
        this.stream = stream;
        this.size = size;
        this.buffer = pool.getBuf(size);
        index = 0;
    }

    public PoolingOutputStream(OutputStream stream) {
        this(stream, DEFAULT_SIZE);
    }

    @Override
    public synchronized void write(int oneByte) throws IOException {
        if (index >= size) {
            stream.write(buffer);
            index = 0;
        }
        buffer[index++] = (byte) oneByte;
    }

    public void write(byte[] bs) throws IOException {
        for (byte b : bs) {
            write(b);
        }
    }

    public void flush() throws IOException {
        if (index > 0) {
            stream.write(buffer, 0, index );
            index=0;
        }
    }

    public void write(byte[] bs, int offset, int length) throws IOException {
        for(int i=offset;i<length+offset;++i){
            write(bs[i]);
        }
    }

    public void close() {
        pool.returnBuf(buffer);
    }

    @Override
    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        pool.returnBuf(buffer);
    }
}
