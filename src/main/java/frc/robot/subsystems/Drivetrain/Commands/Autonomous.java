// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.Arm.Arm;
import frc.robot.subsystems.Drivetrain.Drivetrain;

public class Autonomous extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance.
   *
   * @param drivetrain The drivetrain subsystem to use in the commands below.
   * @param arm The arm subsystem to use in the commands below.
   */
  public Autonomous(Drivetrain drivetrain, Arm arm) {
    addCommands(
      new DriveDistance(-1, 10, drivetrain),
      new TurnDegrees(-1, 180, drivetrain),
      new DriveDistance(-1, 10, drivetrain),
      new TurnDegrees(1, 180, drivetrain),
      new ArmDegrees(170, arm),
      new GripperDegrees(15, arm),
      new DriveDistance(1, 6, drivetrain),
      new GripperDegrees(90, arm)
    );
  }
}