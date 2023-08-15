// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Arm.Arm;

public class ArmDegrees extends CommandBase {
  private final Arm arm;
  private final double degrees;

  /**
   * Creates a new ArmDegrees command. This command will set the arm servo on your robot to a desired number of degrees.
   *
   * @param arm The subsystem this command will run on.
   * @param degrees The number of degrees that the arm will be set to.
   */
  public ArmDegrees(Arm arm, double degrees) {
    this.arm = arm;
    this.degrees = degrees;
    addRequirements(arm);
  }

  /** Called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    arm.setArmAngle(degrees);
  }

  /** Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return arm.getArmAngle() == degrees;
  }
}