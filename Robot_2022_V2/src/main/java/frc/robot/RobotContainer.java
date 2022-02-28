// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.AdvanceBall;
import frc.robot.commands.ReverseBall;
import frc.robot.commands.DeployArm;
import frc.robot.commands.RetractArm;
import frc.robot.commands.ShootHigh;
import frc.robot.commands.ShootLow;
import frc.robot.commands.ShootStop;
import frc.robot.commands.AutonomousCommand;
import frc.robot.commands.DefaultDrive;
import frc.robot.commands.WinchUnwind;
import frc.robot.commands.WinchRaise;
import frc.robot.commands.DefaultDrive;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.ConveyorBelt;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.IntakeRoller;
import frc.robot.subsystems.Hooks;
import frc.robot.subsystems.Winch;

import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final ExampleCommand m_exampleCommand = new ExampleCommand(m_exampleSubsystem);
  
  private final DriveTrain m_drive = new DriveTrain();

  private final IntakeArm m_intake = new IntakeArm();
  private final DeployArm m_deployArm = new DeployArm(m_intake);
  private final RetractArm m_retractArm = new RetractArm(m_intake);

  private final ConveyorBelt m_conveyorBelt = new ConveyorBelt();
  private final AdvanceBall m_advanceBall = new AdvanceBall(m_conveyorBelt);
  private final ReverseBall m_reverseBall = new ReverseBall(m_conveyorBelt);

  private final Shooter m_shooter = new Shooter();
  private final ShootHigh m_shootHigh = new ShootHigh(m_shooter);
  private final ShootLow m_shootLow = new ShootLow(m_shooter);
  private final ShootStop m_shootStop = new ShootStop(m_shooter);

  private final Winch m_winch = new Winch();
   private final WinchRaise m_winchWind = new WinchRaise(m_winch);
   private final WinchUnwind m_winchUnwind = new WinchUnwind(m_winch);

  // Set up subsystems on toggle commands
  private final IntakeRoller m_roller = new IntakeRoller();
  private final Hooks m_hooks = new Hooks();

  private final AutonomousCommand m_autoCommand = new AutonomousCommand(m_drive, m_shooter, m_conveyorBelt);

  // Set up Joystick and Button Board.
  private Joystick m_stick = new Joystick(0);
  private GenericHID m_buttonBoard = new GenericHID(1);

  // Set up Button Board Buttons and Joystick Buttons.
  
  private JoystickButton intakeDeploy = new JoystickButton(m_buttonBoard, 5);
  private JoystickButton intakeRetract = new JoystickButton(m_buttonBoard, 2);
  private JoystickButton intakeRoller = new JoystickButton(m_buttonBoard, 3);
  private JoystickButton climbingHooks = new JoystickButton(m_buttonBoard,14);

  private JoystickButton beltAdvance  = new JoystickButton(m_buttonBoard, 4);
  private JoystickButton beltReverse = new JoystickButton(m_buttonBoard, 1);

  private JoystickButton shootHigh = new JoystickButton(m_buttonBoard, 8);
  private JoystickButton shootLow = new JoystickButton(m_buttonBoard, 15);
  private JoystickButton shootStop = new JoystickButton(m_buttonBoard, 6);

  private JoystickButton Winchwind = new JoystickButton(m_buttonBoard, 12);
  private JoystickButton Winchunwind = new JoystickButton(m_buttonBoard, 16);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    m_drive.setDefaultCommand(
      new DefaultDrive(
        m_drive, m_stick::getY, m_stick::getX));

    // Configure the button bindings
    configureButtonBindings();
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Conveyor Belt
    beltAdvance.whenHeld(m_advanceBall);
    beltReverse.whenHeld(m_reverseBall);

    // Intake Arm in and out
    intakeDeploy.whenPressed(m_deployArm);
    intakeRetract.whenPressed(m_retractArm);

    // Shooter
    shootHigh.whenActive(m_shootHigh);
    shootLow.whenPressed(m_shootLow);
    shootStop.whenPressed(m_shootStop);

    // Toggle intake roller on and off.
    intakeRoller.toggleWhenPressed(new StartEndCommand(m_roller::pullBall, m_roller::stop, m_roller)); 

    // Toggle extends and retracts climbing hooks.
    climbingHooks.toggleWhenPressed(new StartEndCommand(m_hooks::extendHooks, m_hooks::retractHooks, m_hooks));
    
    // Winch
    Winchwind.whenHeld(m_winchWind);
    Winchunwind.whenHeld(m_winchUnwind);

    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
