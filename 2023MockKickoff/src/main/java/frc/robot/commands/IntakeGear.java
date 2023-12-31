// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.GearIntake;

public class IntakeGear extends CommandBase {

  private final BooleanSupplier cancel;
  private final GearIntake subsystem;

  /** Creates a new IntakeGear. */
  public IntakeGear(GearIntake subsystem, BooleanSupplier cancel) {

    this.cancel = cancel;
    this.subsystem = subsystem;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    subsystem.setMotorPower(-0.3);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem.setMotorPower(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (subsystem.getBeamBreakValue() | cancel.getAsBoolean());
  }
}
