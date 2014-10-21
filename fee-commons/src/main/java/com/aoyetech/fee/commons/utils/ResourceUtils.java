package com.aoyetech.fee.commons.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Properties;

/**
 * @author <a href=mailto://wq163@163.com>jenwang</a>
 * @since 2012-9-7
 */
public class ResourceUtils extends Object {

    /** */
    /**
     * Returns the URL of the resource on the classpath
     * 
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static URL getResourceURL(final String resource) throws IOException {
        URL url = null;
        final ClassLoader loader = ResourceUtils.class.getClassLoader();
        if (loader != null) {
            url = loader.getResource(resource);
        }
        if (url == null) {
            url = ClassLoader.getSystemResource(resource);
        }
        if (url == null) {
            throw new IOException("Could not find resource " + resource);
        }
        return url;
    }


    /** */
    /**
     * Returns the URL of the resource on the classpath
     * 
     * @param loader The classloader used to load the resource
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static URL getResourceURL(final ClassLoader loader, final String resource)
            throws IOException {
        URL url = null;
        if (loader != null) {
            url = loader.getResource(resource);
        }
        if (url == null) {
            url = ClassLoader.getSystemResource(resource);
        }
        if (url == null) {
            throw new IOException("Could not find resource " + resource);
        }
        return url;
    }


    /** */
    /**
     * Returns a resource on the classpath as a Stream object
     * 
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static InputStream getResourceAsStream(final String resource) throws IOException {
        InputStream in = null;
        final ClassLoader loader = ResourceUtils.class.getClassLoader();
        if (loader != null) {
            in = loader.getResourceAsStream(resource);
        }
        if (in == null) {
            in = ClassLoader.getSystemResourceAsStream(resource);
        }
        if (in == null) {
            throw new IOException("Could not find resource " + resource);
        }
        return in;
    }


    /** */
    /**
     * Returns a resource on the classpath as a Stream object
     * 
     * @param loader The classloader used to load the resource
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static InputStream getResourceAsStream(final ClassLoader loader, final String resource)
            throws IOException {
        InputStream in = null;
        if (loader != null) {
            in = loader.getResourceAsStream(resource);
        }
        if (in == null) {
            in = ClassLoader.getSystemResourceAsStream(resource);
        }
        if (in == null) {
            throw new IOException("Could not find resource " + resource);
        }
        return in;
    }


    /** */
    /**
     * Returns a resource on the classpath as a Properties object
     * 
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static Properties getResourceAsProperties(final String resource) throws IOException {
        final Properties props = new Properties();
        InputStream in = null;
        final String propfile = resource;
        try {
            in = getResourceAsStream(propfile);
            props.load(in);

            return props;
        } finally {
            if (in != null) {
                in.close();
            }
        }

    }


    /** */
    /**
     * Returns a resource on the classpath as a Properties object
     * 
     * @param loader The classloader used to load the resource
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static Properties getResourceAsProperties(final ClassLoader loader, final String resource)
            throws IOException {
        final Properties props = new Properties();
        InputStream in = null;
        final String propfile = resource;
        in = getResourceAsStream(loader, propfile);
        props.load(in);
        in.close();
        return props;
    }


    /** */
    /**
     * Returns a resource on the classpath as a Reader object
     * 
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static InputStreamReader getResourceAsReader(final String resource) throws IOException {
        return new InputStreamReader(getResourceAsStream(resource));
    }


    /** */
    /**
     * Returns a resource on the classpath as a Reader object
     * 
     * @param loader The classloader used to load the resource
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static Reader getResourceAsReader(final ClassLoader loader, final String resource)
            throws IOException {
        return new InputStreamReader(getResourceAsStream(loader, resource));
    }


    /** */
    /**
     * Returns a resource on the classpath as a File object
     * 
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static File getResourceAsFile(final String resource) throws IOException {
        return new File(getResourceURL(resource).getFile());
    }


    /** */
    /**
     * Returns a resource on the classpath as a File object
     * 
     * @param loader The classloader used to load the resource
     * @param resource The resource to find
     * @throws IOException If the resource cannot be found or read
     * @return The resource
     */
    public static File getResourceAsFile(final ClassLoader loader, final String resource)
            throws IOException {
        return new File(getResourceURL(loader, resource).getFile());
    }

}
