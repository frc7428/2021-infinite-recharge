/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.colorWheel.ColorWheelCommand;
import frc.robot.commands.conveyer.ConveyerCommand;
import frc.robot.commands.drive.AutoDriveCommand;
import frc.robot.commands.drive.AutoDriveWithWaitCommand;
import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.drive.POVDriveCommand;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.shooter.ShooterCommand;
import frc.robot.commands.shooter.ShooterHoodAngleCommand;
import frc.robot.subsystems.ColorWheelSubsystem;
import frc.robot.subsystems.ConveyerSubsystem;
import frc.robot.subsystems.IntakeSubsytem;
import frc.robot.subsystems.MecanumDriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final MecanumDriveSubsystem driveSubsystem = new MecanumDriveSubsystem();
  private final IntakeSubsytem intakeSubsystem = new IntakeSubsytem();
  private final Joystick driveJoystick = new Joystick(Constants.COMPUTER_USB_PORTS.DRIVE_JOYSTICK_USB_ID);
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ColorWheelSubsystem colorWheelSubsystem = new ColorWheelSubsystem();
  private final XboxController driveController = new XboxController(Constants.COMPUTER_USB_PORTS.XBOX_CONTROLLER_USB_ID);
  private final ConveyerSubsystem conveyerSubsystem = new ConveyerSubsystem(); 

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, driveJoystick));
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton intakeButton = new JoystickButton(driveJoystick, Constants.DRIVE_JOYSTICK_BUTTON.INTAKE_BUTTON);
    intakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, true));
    intakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, true));
    
    JoystickButton inversedIntakeButton = new JoystickButton(driveJoystick, Constants.DRIVE_JOYSTICK_BUTTON.INVERSED_INTAKE_BUTTON);
    inversedIntakeButton.whileHeld(new IntakeCommand(intakeSubsystem, true, false));
    inversedIntakeButton.whenReleased(new IntakeCommand(intakeSubsystem, false, false));

    JoystickButton conveyerButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.CONVEYER_BUTTON);
    conveyerButton.whileHeld(new ConveyerCommand(conveyerSubsystem, true, true));
    conveyerButton.whenReleased(new ConveyerCommand(conveyerSubsystem, false, true));

    JoystickButton inversedConveyerButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.INVERSED_CONVEYER_BUTTON);
    inversedConveyerButton.whileHeld(new ConveyerCommand(conveyerSubsystem, true, false));
    inversedConveyerButton.whenReleased(new ConveyerCommand(conveyerSubsystem, false, false));

    JoystickButton shooterButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.SHOOTER_BUTTON);
    shooterButton.whileHeld(new ShooterCommand(shooterSubsystem, true, true));
    shooterButton.whenReleased(new ShooterCommand(shooterSubsystem, false, true));

    JoystickButton inversedShooterButton = new JoystickButton(driveController, Constants.MECHANISM_XBOX_BUTTONS.INVERSED_SHOOTER_BUTTON);
    inversedShooterButton.whileHeld(new ShooterCommand(shooterSubsystem, true, false));
    inversedShooterButton.whenReleased(new ShooterCommand(shooterSubsystem, false, false));

    JoystickButton colorWheelButton = new JoystickButton(driveController, Constants.COLOR_WHEEL_BUTTON);
    colorWheelButton.whileHeld(new ColorWheelCommand(colorWheelSubsystem, true));
    colorWheelButton.whenReleased(new ColorWheelCommand(colorWheelSubsystem, false));
    
    POVButton driveForwardButton = new POVButton(driveController, Constants.XBOX_POV_BUTTONS.DRIVE_FORWARD);
    driveForwardButton.whileHeld(new POVDriveCommand(driveSubsystem, 1, 0));
    driveForwardButton.whenReleased(new POVDriveCommand(driveSubsystem, 0, 0));

    POVButton driveRightButton = new POVButton(driveController, Constants.XBOX_POV_BUTTONS.DRIVE_RIGHT);
    driveRightButton.whileHeld(new POVDriveCommand(driveSubsystem, 0, 1));
    driveRightButton.whenReleased(new POVDriveCommand(driveSubsystem, 0, 0));

    POVButton driveBackwardButton = new POVButton(driveController, Constants.XBOX_POV_BUTTONS.DRIVE_BACKWARD);
    driveBackwardButton.whileHeld(new POVDriveCommand(driveSubsystem, -1, 0));
    driveBackwardButton.whenReleased(new POVDriveCommand(driveSubsystem, 0, 0));

    POVButton driveLeftButton = new POVButton(driveController, Constants.XBOX_POV_BUTTONS.DRIVE_LEFT);
    driveLeftButton.whileHeld(new POVDriveCommand(driveSubsystem, 0, -1));
    driveLeftButton.whenReleased(new POVDriveCommand(driveSubsystem, 0, 0));


  }
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {

    
    //Test
    return new AutoDriveWithWaitCommand(driveSubsystem, 0.75, 0, 0, 0.75);
     

   /** Galatic Search Path B(Blue) - Rough Draft
     return new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0)
     .andThen(new WaitCommand(10))
     .andThen(new AutoDriveCommand(driveSusbsytem, 1, 0, 0))
     .andThen(new WaitCommand(3))
     .andThen(new AutoDriveCommand(driveSubsystem, 0.75, -0.75, 0))
     .andThen(new WaitCOmmand(5))
     .andThen(new AutoDriveCommand(driveSusbsytem, 0.5, 0, 0))
     .andThen(new WaitCommand(1))
     .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0))
     .andThen(new WaitCommand(5))
     .andThen(new AutoDriveCommand(driveSubsystem, 0.5, 0, 0))
     .andThen(new WaitCommand(1))
     .andThen(new AutoDriveCommand(driveSubsystem, 0.75, -0.75, 0))
     .andThen(new WaitCommand(3)
    
    // An ExampleCommand will run in autonomous
    


    /** Slalom Path - Rough Draft
     * return new AutoDriveCommand(driveSubsystem, 0.75, -0.75, 0)
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0, 0))
     * .andThen(new WaitCommand(8))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0))
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubstsem, 0.75, -0.75, -0.75))
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, -0.75, 0))
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0, 0))
     * .andThen(new WaitCommand(8))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0))
     * .andThen(new WaitCommand(3))
    */

    /** Galatic Search Path A(Red) - Rough Draft
     * return new AutoDriveCommand(driveSubsystem, 0.75, 0.25, 0)
     * .andThen(new WaitCommand(5))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, -0.75, 0))
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.25, -1, 0))
     * .andThen(new WaitCommand(5))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0))
     * .andThen(new WaitCommand(10))
    */

    /** Galatic Search Path A(Blue) - Rough Draft
     * return new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0)
     * .andThen(new WaitCommand(8))
     * .andThen(new AutoDriveCommand(driveSubsystem, 1, 0, 0))
     * .andThen(new Wait Command(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.25, -1, 0))
     * .andThen(new WaitCommand(5))
     * .andThen(new AutoDriveCommand(driveSubsystem, .75, 0, 0))
     * .andThen(new WaitCommand(1))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.5, 0,5 0))
     * .andThen(new WaaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 1, 0, 0))
     * .andThen(new WaitCommand(1))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.5, 0.5, 0))
     * .andThen(new WaitCommand(5))
    */

    /** Galatic Search Path B(Red) - Rough Draft
     * return new AutoDriveCommand(driveSubsystem, 0.75, -0.75, 0)
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 1, 0, 0))
     * .andThen(new WaitCommand(2))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.25, 0.75, 0))
     * .andThen(new WaitCommand(5))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.5, 0, 0))
     * .andThen(new WaitCommand(1))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.5, -0.75, 0))
     * .andThen(new WaitCommand(5))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.5, 0, 0))
     * .andThen(new WaitCommand(2))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0))
     * .andThen(new WaitCommand(10))
    */

    /** Galatic Search Path B(Blue) - Rough Draft
     * return new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0)
     * .andThen(new WaitCommand(10))
     * .andThen(new AutoDriveCommand(driveSusbsytem, 1, 0, 0))
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, -0.75, 0))
     * .andThen(new WaitCOmmand(5))
     * .andThen(new AutoDriveCommand(driveSusbsytem, 0.5, 0, 0))
     * .andThen(new WaitCommand(1))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0))
     * .andThen(new WaitCommand(5))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.5, 0, 0))
     * .andThen(new WaitCommand(1))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, -0.75, 0))
     * .andThen(new WaitCommand(3)
    */

    /** Barrel Racing Path - Rough Draft
     * return new AutoDriveCommand(driveSubsystem, 0.75, -0.5, 0)
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0.5))
     * .andThen(new WaitCommand(5))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, -0.75, 0))
     * .andThen(new WaitCommand(5))
     * .andThen(new AutoDriveCommand(0.75, -0.75, -0.5))
     * .andThen(new WaitCommand(5))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0.25))
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0, 0))
     * .andThen(new WaitCommand(2))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, -0.75, -0.5))
     * .andThen(new WaitCommand(3))
     * .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0, 0.25))
     * .andThen(new WaitCommand(2))
     * .andThen(new AutoDriveCommand(driveSubsystem, 1, 0, 0))
     * .andThen(new WaitCommand(10))
    */

    /**   Bounce Path - Rough Draft
      return new AutoDriveCommand(driveSubsystem, 0.75, 0, -0.75)
      .andThen(new WaitCommand(3))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0, 0))
      .andThen(new WaitCommand(2))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.25, 0, 1))
      .andThen(new WaitCommand(2))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.75, -0.25, 0))
      .andThen(new WaitCommand(3))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0, 0))
      .andThen(new WaitCommand(4))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0, -0.5))
      .andThen(new WaitCommand(5))
      .andThen(new AutoDriveCommand(driveSubsystem, 1, 0, 0))
      .andThen(new WaitCommand(10))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.25, 0, 1))
      .andThen(new WaitCommand(2))
      .andThen(new AutoDriveCommand(driveSubsystem, 1, 0, 0))
      .andThen(new WaitCommand(6))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.75, 0.25,))
      .andThen(new WaitCommand(5))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0.25, 0))
      .andThen(new WaitCommand(1))
      .andThen(new AutoDriveCommand(driveSubsystem, 1, 0, 0))
      .andThen(new WaitCommand(2))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.25, 0, 1))
      .andThen(new WaitCommand(2))
      .andThen(new AutoDriveCommand(driveSubsystem, 0.75, 0, 0.5))
      .andThen(new WaitCommand(3))
    */
    

  }

  }
