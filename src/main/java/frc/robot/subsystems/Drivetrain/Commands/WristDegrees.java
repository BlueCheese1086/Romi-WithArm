// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Arm.Arm;

public class WristDegrees extends CommandBase {
  private final double degrees;
  private final Arm arm;

  /**
   * Creates a new WristDegrees command. This command will set the wrist of your robot to a desired number of degrees.
   *
   * @param degrees The number of degrees the wrist will be set to.
   * @param arm The arm subsystem on which this command will run.
   */
  public WristDegrees(double degrees, Arm arm) {
    this.degrees = degrees;
    this.arm = arm;
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.setWristAngle(degrees);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Compare distance travelled from start to desired distance
    return arm.getWristAngle() == degrees;
  }
}