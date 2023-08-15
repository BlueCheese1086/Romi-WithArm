// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;

public class Arm extends SubsystemBase {
  // Creates servos
  private final Servo arm = new Servo(RobotMap.ARMSERVO);
  private final Servo gripper = new Servo(RobotMap.GRIPPERSERVO);
  private final Servo wrist = new Servo(RobotMap.WRISTSERVO);

  /** Creates a new Arm. */
  public Arm() {
    arm.setAngle(90);
    gripper.setAngle(90);
    wrist.setAngle(90);
  }

  /** Sets the angle of the arm. */
  public void setArmAngle(double angle) {
    arm.setAngle(angle);
  }

  /** Returns the angle of the arm. */
  public double getArmAngle() {
    return arm.getAngle();
  }

  /** Sets the angle of the gripper. */
  public void setGripperAngle(double angle) {
    arm.setAngle(angle);
  }

  /** Returns the angle of the gripper. */
  public double getGripperAngle() {
    return arm.getAngle();
  }

  /** Sets the angle of the wrist. */
  public void setWristAngle(double angle) {
    wrist.setAngle(angle);
  }

  /** Returns the angle of the wrist. */
  public double getWristAngle() {
    return wrist.getAngle();
  }
}