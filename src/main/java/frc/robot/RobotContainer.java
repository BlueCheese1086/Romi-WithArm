// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// For programming the arm, I used a great guide from https://www.chiefdelphi.com/t/romi-whats-next/419115/5

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.SNESController.Button;
import frc.robot.subsystems.Arm.Arm;
import frc.robot.subsystems.Arm.Commands.*;
import frc.robot.subsystems.Drivetrain.Drivetrain;
import frc.robot.subsystems.Drivetrain.Commands.*;
import frc.robot.subsystems.OnBoardIO.OnBoardIO;
import frc.robot.subsystems.OnBoardIO.Commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods other than scheduler calls. This being the case, the structure of the robot should be declared here.
 */
public class RobotContainer {
  // Creates the various subsystems for the robot.
  private final Drivetrain drivetrain = new Drivetrain();
  private final OnBoardIO onboardIO = new OnBoardIO(OnBoardIO.ChannelMode.INPUT, OnBoardIO.ChannelMode.INPUT);
  private final Arm arm = new Arm();

  // Looks for an SNES controller on port 0.
  private final SNESController snesController = new SNESController(0);

  // NOTE: The I/O pin functionality of the 5 exposed I/O pins depends on the hardware "overlay"
  // that is specified when launching the wpilib-ws server on the Romi raspberry pi.
  // Your subsystem configuration should take any overlays into account

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.
   * Buttons can be created by instantiating a {@link GenericHID}
   * or one of its subclasses such as {@link Joystick},
   * and then passing it to a {@link JoystickButton}.
   */
  private void configureButtonBindings() {
    // Example of how to use the onboard IO
    Trigger aButton = new Trigger(onboardIO::getButtonAPressed);
    Trigger bButton = new Trigger(onboardIO::getButtonBPressed);
    Trigger cButton = new Trigger(onboardIO::getButtonCPressed);
    aButton.onTrue(new PrintCommand("Button A Pressed"));
    aButton.onTrue(new SetYellow(onboardIO, true));
    aButton.onFalse(new PrintCommand("Button A Released"));
    aButton.onFalse(new SetYellow(onboardIO, false));
    bButton.onTrue(new PrintCommand("Button B Pressed"));
    bButton.onTrue(new SetYellow(onboardIO, true));
    bButton.onFalse(new PrintCommand("Button B Released"));
    bButton.onFalse(new SetYellow(onboardIO, false));
    cButton.onTrue(new PrintCommand("Button C Pressed"));
    cButton.onTrue(new SetYellow(onboardIO, true));
    cButton.onFalse(new PrintCommand("Button C Released"));
    cButton.onFalse(new SetYellow(onboardIO, false));

    // Configures buttons
    new JoystickButton(snesController, Button.LeftBumper.value).whileTrue(new ArmDown(arm));
    new JoystickButton(snesController, Button.RightBumper.value).whileTrue(new ArmUp(arm));
    new JoystickButton(snesController, Button.XButton.value).whileTrue(new WristUp(arm));
    new JoystickButton(snesController, Button.YButton.value).whileTrue(new WristDown(arm));
    new JoystickButton(snesController, Button.AButton.value).whileTrue(new GripperOpen(arm));
    new JoystickButton(snesController, Button.BButton.value).whileTrue(new GripperClose(arm));
  }

  /**
   * Passes the autonomous command to the {@link Robot} class.
   *
   * @return The command to run in autonomous.
   */
  public Command getAutonomousCommand() {
    return new Autonomous(drivetrain, arm);
  }

  /**
   * Passes the teleop command to the {@link Robot} class.
   *
   * @return The command to run in teleop.
   */
  public Command getTeleopCommand() {
    return new ArcadeDrive(drivetrain, () -> -snesController.getYAxis(), () -> -snesController.getXAxis());
  }
}