package com_spring_core7_$5_resourceaware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class ResourceL implements ResourceLoaderAware {

	private static ResourceLoader resourceLoader;

	/**
	 * @return the resourceAware
	 */
	public static ResourceLoader getResourceL() {
		return resourceLoader;
	}

	/**
	 * @param resourceAware
	 *            the resourceAware to set
	 */
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;

	}

}
