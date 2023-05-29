// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

import frc.robot.Constants.RobotMap;

public class Wrist extends SubsystemBase {
  // Creates servo
  private final Servo wrist = new Servo(RobotMap.WRISTSERVO);

  /** Creates a new Wrist. */
  public Wrist() {
    wrist.setAngle(90);
  }

  /** Sets the angle of the wrist */
  public void setAngle(double angle) {
    wrist.setAngle(angle);
  }

  /** Gets the angle of the wrist */
  public double getAngle() {
    return wrist.getAngle();
  }

  /** This method will be called once per scheduler run */
  @Override
  public void periodic() {}
}