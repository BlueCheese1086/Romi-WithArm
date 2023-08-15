// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Arm.Arm;

public class WristDegrees extends CommandBase {
  private final Arm arm;
  private final double degrees;

  /**
   * Creates a new WristDegrees command. This command will set the wrist servo of your robot to a desired number of degrees.
   *
   * @param arm The subsystem this command will run on.
   * @param degrees The number of degrees that the wrist will be set to.
   */
  public WristDegrees(Arm arm, double degrees) {
    this.arm = arm;
    this.degrees = degrees;
    addRequirements(arm);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.setWristAngle(degrees);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return arm.getWristAngle() == degrees;
  }
}