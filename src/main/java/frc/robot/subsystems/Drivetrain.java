/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/**
 * Drivetrain subsystem.
 */
public class Drivetrain extends Subsystem {

  //instantiate global variables
  private TalonSRX frontLeftController;
  private VictorSPX frontRightController;
  private VictorSPX backLeftController;
  private VictorSPX backRightController;

  //constructor
  public Drivetrain() {

    //initialize variables (motor controllers with IDs)
    frontLeftController = new TalonSRX(1);
    frontRightController = new VictorSPX(2);
    backLeftController = new VictorSPX(3);
    backRightController = new VictorSPX(4);
    
    //set back motor controllers to follow front motor controllers
    backLeftController.follow(frontLeftController);
		backRightController.follow(frontRightController);

  }

  //set motor controllers to percents
  public void drivePercent(double leftPercent, double rightPercent) {

    //multiply percents by forward constants
    double leftPercentForward = leftPercent * RobotMap.LEFT_DRIVETRAIN;
		double rightPercentForward = rightPercent * RobotMap.RIGHT_DRIVETRAIN;
    
    //set motor controllers to percents
    frontLeftController.set(ControlMode.PercentOutput, leftPercentForward);
		frontRightController.set(ControlMode.PercentOutput, rightPercentForward);
  }

  //set default command
  public void initDefaultCommand(Command c) {
    setDefaultCommand(c);
  }

  @Override
  public void initDefaultCommand() {
  }
}
