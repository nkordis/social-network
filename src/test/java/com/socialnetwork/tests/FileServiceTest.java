package com.socialnetwork.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.socialnetwork.App;
import com.socialnetwork.service.FileService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
@Transactional
public class FileServiceTest {

	@Autowired
	private FileService fileService;

	@Value("${photo.upload.directory}")
	private String photoUploadDirectory;

	@Test
	public void testGetExtension() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = FileService.class.getDeclaredMethod("getFileExtension", String.class);
		method.setAccessible(true);

		assertEquals("Should be png", "png", (String) method.invoke(fileService, "test.png"));
		assertEquals("Should be png", "doc", (String) method.invoke(fileService, "s.doc"));
		assertEquals("Should be png", "jpeg", (String) method.invoke(fileService, "test.jpeg"));
		assertNull("Should be null", (String) method.invoke(fileService, "xyz"));
	}

	@Test
	public void testisImageExtension() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = FileService.class.getDeclaredMethod("isImageExtension", String.class);
		method.setAccessible(true);

		assertTrue("png hould be valid", (Boolean) method.invoke(fileService, "png"));
		assertTrue("PNG should be valid", (Boolean) method.invoke(fileService, "PNG"));
		assertTrue("jpeg should be valid", (Boolean) method.invoke(fileService, "jpeg"));
		assertTrue("gif should be valid", (Boolean) method.invoke(fileService, "gif"));
		assertTrue("Gif should be valid", (Boolean) method.invoke(fileService, "Gif"));
		assertFalse("Should be invalid", (Boolean) method.invoke(fileService, "png3"));
		assertFalse("Should be invalid", (Boolean) method.invoke(fileService, "pn"));
		assertFalse("Should be invalid", (Boolean) method.invoke(fileService, "doc"));

	}

	@Test
	public void testMakeSubdirectory() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = FileService.class.getDeclaredMethod("makeSubdirectory", String.class, String.class);
		method.setAccessible(true);

		for(int i = 1; i < 10000; i++) {
			
			File created = (File) method.invoke(fileService, photoUploadDirectory, "photo");
			assertTrue("Directory should exists" + created.getAbsolutePath(), created.exists());

			
		}
	}

}
