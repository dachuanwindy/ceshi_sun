package com.classLoaderStudy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author sunfch
 * @version V1.0
 * @Description: 自定义的类加载器
 * <p>
 * 1.继承队形
 * @date 2020/5/7 23:21
 */

public class MyFileClassLoader extends ClassLoader {

    private String fileName;

    public MyFileClassLoader(String fileName) {
        super();
        this.fileName = fileName;
    }


    /**
     * Finds the class with the specified <a href="#name">binary name</a>.
     * This method should be overridden by class loader implementations that
     * follow the delegation model for loading classes, and will be invoked by
     * the {@link #loadClass <tt>loadClass</tt>} method after checking the
     * parent class loader for the requested class.  The default implementation
     * throws a <tt>ClassNotFoundException</tt>.
     *
     * @param name The <a href="#name">binary name</a> of the class
     * @return The resulting <tt>Class</tt> object
     * @since 1.2
     */
    @Override
    protected Class<?> findClass(String name) {

        try {
            String file = fileName + File.separator + name.replace(".", File.separator) + ".class";
            InputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];

            int len = -1;
            while ((len = fileInputStream.read()) != -1) {
                outputStream.write(bytes, 0, len);
            }
            System.out.println();
            byte[] bytes1 = outputStream.toByteArray();
            return defineClass(fileName, bytes1, 0, len);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
