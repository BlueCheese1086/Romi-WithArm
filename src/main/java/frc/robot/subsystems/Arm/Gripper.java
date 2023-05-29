// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

import frc.robot.Constants.RobotMap;

public class Gripper extends SubsystemBase {
  // Creates servo
  private final Servo gripper = new Servo(RobotMap.GRIPPERSERVO);

  /** Creates a new Gripper. */
  public Gripper() {
    gripper.setAngle(90);
  }

  /** Sets the angle of the gripper */
  public void setAngle(double angle) {
    gripper.setAngle(angle);
  }

  /** Gets the angle of the gripper. */
  public double getAngle() {
    return gripper.getAngle();
  }

  /** This method will be called once per scheduler run */
  @Override
  public void periodic() {}
}