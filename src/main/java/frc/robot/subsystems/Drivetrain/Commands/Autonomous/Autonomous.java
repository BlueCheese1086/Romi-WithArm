// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Drivetrain.Commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Arm.*;

public class Autonomous extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run.
   * @param arm The arm subsystem on which this command will run.
   * @param gripper The gripper subsystem on which this command will run.
   * @param wrist The wrist subsystem on which this command will run.
   */
  public Autonomous(Drivetrain drivetrain, Arm arm, Gripper gripper, Wrist wrist) {
    addCommands(
      new DriveDistance(-1, 10, drivetrain),
      new TurnDegrees(-1, 180, drivetrain),
      new DriveDistance(-1, 10, drivetrain),
      new TurnDegrees(1, 180, drivetrain),
      new ArmDegrees(170, arm),
      new GripperDegrees(15, gripper),
      new DriveDistance(1, 6, drivetrain),
      new GripperDegrees(90, gripper)
    );
  }
}