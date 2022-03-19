// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  /** Creates a new shooter subsystem. */
  private final PWMSparkMax m_shooterLeft = new PWMSparkMax(4);
  private final PWMSparkMax m_shooterRight = new PWMSparkMax(5);
  private final MotorControllerGroup m_shooter = new MotorControllerGroup(m_shooterLeft, m_shooterRight);
 

  public Shooter() {
    addChild("Shooter", m_shooter);
    m_shooterRight.setInverted(false);
    m_shooterLeft.setInverted(true);
    
  }

  
  public void highGoal() {
    m_shooter.set(1);
    // Shoots ball into high goal. Runs shooter for 10 seconds.
  }

  public void lowGoal() {
    m_shooter.set(0.65);
    // Shoots ball into low goal.
  }
 
  public void gentleEject() {
    m_shooter.set(0.5);
  }

  public void stop() {
    m_shooter.set(0);
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
