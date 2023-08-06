// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.RobotMap;

public class Arm extends SubsystemBase {
  // Creates servo
  private final Servo arm = new Servo(RobotMap.ARMSERVO);

  /** Creates a new Arm. */
  public Arm() {
    arm.setAngle(90);
  }

  /** Sets the angle of the arm */
  public void setAngle(double angle) {
    arm.setAngle(angle);
  }

  /** @return The current angle of the arm */
  public double getAngle() {
    return arm.getAngle();
  }

  /** This method will be called once per scheduler run */
  @Override
  public void periodic() {}
}