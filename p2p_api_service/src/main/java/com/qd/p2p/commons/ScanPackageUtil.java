package com.qd.p2p.commons;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * 扫包获取指定接口子类型
 * @author linya
 */
public class ScanPackageUtil {
	
	/**
	* 取得当前类路径下的所有类
	* 
	* @param cls
	* @return
	* @throws IOException
	* @throws ClassNotFoundException
	*/
	public static <T> Set<Class<T>> getClasses(String basePackage, Class<T> requiredType){
		String packagePath = basePackage.replace('.', '/');
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL resource = classloader.getResource(packagePath);
		File packageDir = new File(resource.getFile());
		return getClasses(packageDir, basePackage, requiredType);
	}

	/**
	 * 迭代查找类
	 * @param dir
	 * @param pk
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	private static <T> Set<Class<T>> getClasses(File dir, String packageName, Class<T> requiredType) {
		Set<Class<T>> classes = new HashSet<Class<T>>();
		
		if (!dir.exists()) {
			return classes;
		}
		
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				Set<Class<T>> childrenPageckageClasses = getClasses(f, packageName + "." + f.getName(), requiredType);
				classes.addAll(childrenPageckageClasses);
			}
			String name = f.getName();
			if (name.endsWith(".class")) {
				String className = name.substring(0, name.length() - 6);
				Class<T> clazz = (Class<T>) forName(packageName + "." + className);
				if(requiredType.isAssignableFrom(clazz)
						&& !clazz.isInterface() 
						&& (clazz.getModifiers() & Modifier.ABSTRACT) == 0){
					classes.add(clazz);
				}
			}
		}
		
		return classes;
	}
	
	private static Class<?> forName(String className){
		Class<?> clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// ignore
		}
		return clazz;
	}
}
