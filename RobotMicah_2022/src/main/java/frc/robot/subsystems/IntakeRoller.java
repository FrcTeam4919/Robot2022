// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeRoller extends SubsystemBase {
  /** Creates a new intake roller subsystem. */
  private final PWMSparkMax m_roller = new PWMSparkMax(2);
  
  public IntakeRoller() {
    addChild("Intake Roller", m_roller);
  }

  
  public void pullBall() {
    m_roller.set(0.5);
    // Spins and pulls ball in toward intake.
  }

  public void pushBall() {
    m_roller.set(-0.5);
    // Spins and pushes ball away from robot.
  }
 
  public void stop() {
    m_roller.set(0);
  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
