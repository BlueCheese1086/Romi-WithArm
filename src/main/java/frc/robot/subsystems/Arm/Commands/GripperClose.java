// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Motors;
import frc.robot.subsystems.Arm.Gripper;

public class GripperClose extends CommandBase {
  private final Gripper gripper;

  /**
   * Creates a new GripperClose command. This command will close the gripper of your robot while a button is pressed.
   *
   * @param gripper The gripper subsystem on which this command will run
   */
  public GripperClose(Gripper gripper) {
    this.gripper = gripper;
    addRequirements(gripper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs the command while it is scheduled.
  @Override
  public void execute() {
    double angle = gripper.getAngle();
    if(angle + Motors.INCREMENT > 90) {
      gripper.setAngle(angle);
    } else {
      gripper.setAngle(gripper.getAngle() + Motors.INCREMENT);
    }
  }

  // Called when the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}