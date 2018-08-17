package com.javarush.task.task31.task3110;

/**
 * Created by Home PC Volkov on 12.02.2018.
 */
public class FileProperties {
    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public long getCompressedSize() {
        return compressedSize;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    public long getCompressionRatio() {
        return (100 - ((compressedSize * 100) / size));
    }

    @Override
    public String toString() {
        String str = name;
        StringBuilder stringBuilder = new StringBuilder(str);
        if (size > 0) {
            stringBuilder.append(" ").append(getSize()/1024).append(" Kb (").append(getCompressedSize()/1024).append(" Kb) ");
            stringBuilder.append(getCompressionMethod()).append(": ").append(getCompressionRatio()).append("%");

        }
        return stringBuilder.toString();
    }
}
