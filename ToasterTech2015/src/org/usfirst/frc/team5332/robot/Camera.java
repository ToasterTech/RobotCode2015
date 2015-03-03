package org.usfirst.frc.team5332.robot;

import edu.wpi.first.wpilibj.CameraServer;
/*
 * A class to setup the camera to stream to the driver station. 
 */
public class Camera {
	private String name;
	public Camera(String n){
		name=n;
	}
	public void init(){
		CameraServer server = CameraServer.getInstance();
		server.setQuality(50);
		server.startAutomaticCapture(name);
	}
}
