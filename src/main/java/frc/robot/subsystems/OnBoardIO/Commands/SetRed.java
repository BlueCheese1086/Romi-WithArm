// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.OnBoardIO.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.subsystems.OnBoardIO.OnBoardIO;

public class SetRed extends Command {
  private final OnBoardIO onboardIO;
  private final boolean state;

  /**
   * Creates a new SetRed command. This command will set the state of the red light to whatever the input is.
   *
   * @param onboardIO The subsystem this command will run on.
   * @param state The state the light will be set to.
   */
  public SetRed(OnBoardIO onboardIO, boolean state) {
    this.onboardIO = onboardIO;
    this.state = state;
  }

  /** This function is called every time the scheduler runs while the command is scheduled. */
  @Override
  public void execute() {
    onboardIO.setRedLed(state);
  }

  /** This function returns true when the command should end. */
  @Override
  public boolean isFinished() {
    return false;
  }
}