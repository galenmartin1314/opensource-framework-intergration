package com.gm.ofi.mongo.factory;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.github.jmkgreen.morphia.Morphia;

public class MorphiaFactoryBean extends AbstractFactoryBean<Morphia> {
	/**
	 * 要扫描并映射的包
	 */
	private String[] mapPackages;

	public void setMapPackages(String[] mapPackages) {
		this.mapPackages = mapPackages;
	}

	public void setMapClasses(String[] mapClasses) {
		this.mapClasses = mapClasses;
	}

	public void setIgnoreInvalidClasses(boolean ignoreInvalidClasses) {
		this.ignoreInvalidClasses = ignoreInvalidClasses;
	}

	/**
	 * 要映射的类
	 */
	private String[] mapClasses;

	/**
	 * 扫描包时，是否忽略不映射的类 这里按照Morphia的原始定义，默认设为false
	 */
	private boolean ignoreInvalidClasses;

	@Override
	protected Morphia createInstance() throws Exception {
		Morphia m = new Morphia();
		if (mapPackages != null) {
			for (String packageName : mapPackages) {
				m.mapPackage(packageName, ignoreInvalidClasses);
			}
		}
		if (mapClasses != null) {
			for (String entityClass : mapClasses) {
				m.map(Class.forName(entityClass));
			}
		}
		return m;
	}

	@Override
	public Class<?> getObjectType() {
		return Morphia.class;
	}
}
