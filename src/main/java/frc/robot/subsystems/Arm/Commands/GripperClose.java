// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants.Motors;
import frc.robot.subsystems.Arm.Arm;

public class GripperClose extends Command {
  private final Arm arm;

  /**
   * Creates a new GripperClose command. This command will close the gripper of your robot while a button is pressed.
   *
   * @param arm The subsystem this command will run on.
   */
  public GripperClose(Arm arm) {
    this.arm = arm;
    addRequirements(arm);
  }

  /** Called every time the scheduler runs the command while it is scheduled. */
  @Override
  public void execute() {
    arm.setGripperAngle(arm.getGripperAngle() + Motors.INCREMENT);
  }

  /** Returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}