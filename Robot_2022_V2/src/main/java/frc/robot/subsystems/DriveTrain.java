// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;


public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private final PWMSparkMax m_leftDrive = new PWMSparkMax(0);
  private final PWMSparkMax m_rightDrive = new PWMSparkMax(1);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftDrive, m_rightDrive);
  
  public DriveTrain() {
    m_leftDrive.setInverted(true);
  }


  /**
   * 
   * @param fwd
   * @param rot
   */
  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot);
  }

  public void driveStraight() {
    m_drive.arcadeDrive(0.75, 0);
  }

  @Override
  public void periodic() {
    
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  /*public Object arcadeDrive(double y, double x, Joystick m_stick) {
    return null;
  }*/
}
