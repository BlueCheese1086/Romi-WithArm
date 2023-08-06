// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Arm.Gripper;

public class GripperDegrees extends CommandBase {
  private final double degrees;
  private final Gripper gripper;

  /**
   * Creates a new gripperDegrees command. This command will move the gripper of your robot to a desired angle.
   *
   * @param degrees The number of degrees that the gripper will be set to.
   * @param gripper The gripper subsystem on which this command will run.
   */
  public GripperDegrees(double degrees, Gripper gripper) {
    this.degrees = degrees;
    this.gripper = gripper;
    addRequirements(gripper);
  }

  /** This function is called when the command is initially scheduled. */
  @Override
  public void initialize() {}

  /** This function is called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    gripper.setAngle(degrees);
  }

  /** This function is called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {}

  /** This function returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return gripper.getAngle() == degrees;
  }
}