// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GearIntake extends SubsystemBase {
  /** Creates a new GearIntake. */
  private final CANSparkMax motor;
  private final DigitalInput beamBreak;

  public GearIntake(int motorID, int IDBeamBreak) {
    motor = new CANSparkMax(motorID, MotorType.kBrushless);
    beamBreak = new DigitalInput(IDBeamBreak);
  }

  public void setMotorPower(double power) {
    motor.set(power);
  }

  public boolean getBeamBreakValue() {

    return !beamBreak.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
