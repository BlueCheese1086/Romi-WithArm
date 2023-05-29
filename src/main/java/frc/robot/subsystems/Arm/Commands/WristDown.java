// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Arm.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.Motors;
import frc.robot.subsystems.Arm.Wrist;

public class WristDown extends CommandBase {
  private final Wrist wrist;

  /**
   * Creates a new WristDown command. This command will move the wrist of your robot down while a button is pressed.
   *
   * @param wrist The wrist subsystem on which this command will run.
   */
  public WristDown(Wrist wrist) {
    this.wrist = wrist;
    addRequirements(wrist);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs the command while it is scheduled.
  @Override
  public void execute() {
    wrist.setAngle(wrist.getAngle() - Motors.INCREMENT);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}