// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// For programming the arm, I used a great guide from https://www.chiefdelphi.com/t/romi-whats-next/419115/5

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.subsystems.Arm.*;
import frc.robot.subsystems.Arm.Commands.*;
import frc.robot.subsystems.Drivetrain.*;
import frc.robot.subsystems.Drivetrain.Commands.Autonomous.*;
import frc.robot.subsystems.Drivetrain.Commands.TeleOp.*;
import frc.robot.subsystems.OnBoardIO.*;
import frc.robot.subsystems.OnBoardIO.OnBoardIO.ChannelMode;
import frc.robot.SNESController.Button;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods other than scheduler calls. This being the case, the structure of the robot should be declared here.
 */
public class RobotContainer {
  // Creates the various subsystems for the robot.
  private final Drivetrain drivetrain = new Drivetrain();
  private final OnBoardIO onboardIO = new OnBoardIO(ChannelMode.INPUT, ChannelMode.INPUT);
  private final Arm arm = new Arm();
  private final Gripper gripper = new Gripper();
  private final Wrist wrist = new Wrist();

  // Looks for an SNES controller on port 0.
  private final XboxController xboxController = new XboxController(0);
  private final SNESController snesController = new SNESController(1);

  // NOTE: The I/O pin functionality of the 5 exposed I/O pins depends on the hardware "overlay"
  // that is specified when launching the wpilib-ws server on the Romi raspberry pi.
  // Your subsystem configuration should take any overlays into account

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses such as {@link
   * edu.wpi.first.wpilibj.Joystick}, and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Sets the default command for the Romi.
    //drivetrain.setDefaultCommand(getArcadeDriveCommand());

    // Example of how to use the onboard IO
    Trigger aButton = new Trigger(onboardIO::getButtonAPressed);
    Trigger bButton = new Trigger(onboardIO::getButtonBPressed);
    Trigger cButton = new Trigger(onboardIO::getButtonCPressed);
    aButton.onTrue(new PrintCommand("Button A Pressed"));
    aButton.onFalse(new PrintCommand("Button A Released"));
    bButton.onTrue(new PrintCommand("Button B Pressed"));
    bButton.onFalse(new PrintCommand("Button B Released"));
    cButton.onTrue(new PrintCommand("Button C Pressed"));
    cButton.onFalse(new PrintCommand("Button C Released"));

    // Configures buttons
    new JoystickButton(xboxController, Button.LeftBumper.value).whileTrue(new ArmDown(arm));
    new JoystickButton(xboxController, Button.RightBumper.value).whileTrue(new ArmUp(arm));
    new JoystickButton(xboxController, Button.XButton.value).whileTrue(new WristUp(wrist));
    new JoystickButton(xboxController, Button.YButton.value).whileTrue(new WristDown(wrist));
    new JoystickButton(xboxController, Button.AButton.value).whileTrue(new GripperOpen(gripper));
    new JoystickButton(xboxController, Button.BButton.value).whileTrue(new GripperClose(gripper));

    new JoystickButton(xboxController, Button.SelectButton.value).onTrue(new Disable()); // WIP -- Possible kill switch for competition bots
  }

  /**
   * Passes the autonomous command to the {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new Autonomous(drivetrain, arm, gripper, wrist);
  }

  /**
   * Passes the teleop command to the {@link Robot} class.
   *
   * @return the command to run in teleop
   */
  public Command getSNESArcadeDriveCommand() {
    return new ArcadeDrive(drivetrain, () -> -snesController.getRawAxis(1), () -> -snesController.getRawAxis(0));
  }

  public Command getXBOXArcadeDriveCommand() {
    return new ArcadeDrive(drivetrain, () -> -xboxController.getLeftY(), () -> -xboxController.getRightX());
  }
}