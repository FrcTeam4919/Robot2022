// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hooks extends SubsystemBase {
  /** Creates a new hooks subsystem. */
  private final DoubleSolenoid m_intakeDoubleSolenoid = 
     new DoubleSolenoid(
        PneumaticsModuleType.CTREPCM,
        Constants.IntakeConstants.kSolenoidPorts[4],
        Constants.IntakeConstants.kSolenoidPorts[5]);

  public Hooks() {
    
  }



  public void extendHooks() {
    m_intakeDoubleSolenoid.set(kForward);
    // Extends hooks for climbing.
  }

 
  public void retractHooks() {
    m_intakeDoubleSolenoid.set(kReverse);
    // Retracts hooks to reduce load on winch.
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
