package org.usfirst.frc.team5332.robot;

import edu.wpi.first.wpilibj.CameraServer;

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
