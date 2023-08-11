// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.OnBoardIO.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.OnBoardIO.OnBoardIO;

public class SetGreen extends CommandBase {
  private final OnBoardIO onboardIO;
  private boolean state;

  /**
   * Creates a new SetGreen command. This command will set the state of the green light to whatever the input is.
   *
   * @param onboardIO The subsystem this command will run on.
   * @param state The state the light will be set to.
   */
  public SetGreen(OnBoardIO onboardIO, boolean state) {
    this.onboardIO = onboardIO;
    this.state = state;
  }

  /** This function is called when the command is initially scheduled. */
  @Override
  public void initialize() {}

  /** This function is called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    onboardIO.setGreenLed(state);
  }

  /** This function is called once the command ends or is interrupted. */
  @Override
  public void end(boolean interrupted) {}

  /** This function returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}