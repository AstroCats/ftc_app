package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by mjjus on 12/12/2015.
 */
public class Autonomous extends LinearOpMode {

    // TODO: Replace these two guessed distances in measured distances
    final static int FIRST_DISTANCE_IN_ROTATION = 4;
    final static int SECOND_DISTANCE_IN_ROTATION = 3;

    final static int PULSES_PER_ROTATION =   1440; //1440;
    final static int FIRST_DISTANCE_IN_PULSES = PULSES_PER_ROTATION * FIRST_DISTANCE_IN_ROTATION;
    final static int SECOND_DISTANCE_IN_PULSES = PULSES_PER_ROTATION * SECOND_DISTANCE_IN_ROTATION;

    DcMotor motorRightF;
    DcMotor motorRightB;
    DcMotor motorLeftF;
    DcMotor motorLeftB;



    @Override
    public void runOpMode() throws InterruptedException
    {
        telemetry.addData("GLaDOS: Autonomous.runOpMode() (start...)", "");
        telemetry.addData("GLaDOS: Code Version: ", DriverMode.CODE_VERSION);
        motorRightF = hardwareMap.dcMotor.get("frontright");
        motorRightB = hardwareMap.dcMotor.get("backright");
        motorLeftF = hardwareMap.dcMotor.get("frontleft");
        motorLeftB = hardwareMap.dcMotor.get("backleft");

        // TODO: Make sure the motors directions are correct
        motorRightF.setDirection(DcMotor.Direction.FORWARD);
        motorRightB.setDirection(DcMotor.Direction.FORWARD);
        motorLeftF.setDirection(DcMotor.Direction.REVERSE);
        motorLeftB.setDirection(DcMotor.Direction.REVERSE);
        waitOneFullHardwareCycle();


        // TODO: Check to make sure the "reset encoders" command works on
        // motors that don't have encoders (only two of the motors on Robot 1
        // have encoders
/*
        motorRightF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motorRightB.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motorLeftF.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        motorLeftB.setMode(DcMotorController.RunMode.RESET_ENCODERS);
        //motorRightB.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        waitOneFullHardwareCycle();
*/
        telemetry.addData("Autonomous.runOpMode() no reset", "");
        telemetry.addData("Autonomous.runOpMode() (gcurrPos=",motorRightB.getCurrentPosition());

        telemetry.addData("Autonomous.runOpMode() (entering while loop)", "");

        int i = 1;
        while ( 0 != motorRightB.getCurrentPosition() )
        {
            telemetry.addData("  waiting one hw cycle...", i++);
            waitOneFullHardwareCycle();
        }
        telemetry.addData("Autonomous.runOpMode() (exited while loop)", "");
        telemetry.addData("Autonomous.runOpMode() (gcurrPos=",motorRightB.getCurrentPosition());


        /*
        motorRightF.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motorRightB.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motorLeftF.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        motorLeftB.setMode(DcMotorController.RunMode.RUN_TO_POSITION);
        */

        motorLeftB.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motorRightB.setMode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        waitOneFullHardwareCycle();
        telemetry.addData("Autonomous.runOpMode() (gcurrPos=",motorRightB.getCurrentPosition());


        telemetry.addData("GLaDOS: Autonomous.RunOpMode() (init complete without errors).", "");

        /*
        motorLeftB.setTargetPosition((int) FIRST_DISTANCE_IN_PULSES);
        motorRightB.setTargetPosition((int) FIRST_DISTANCE_IN_PULSES);
        */
        //motorLeftB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        //motorRightB.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

        // telemetry.addData("Autonomous.RunOpMode() (distance in pulses=.", FIRST_DISTANCE_IN_PULSES);

        telemetry.addData("Autonomous.RunOpMode() (waiting for start...", "");
        telemetry.addData("Autonomous.runOpMode() (gcurrPos=",motorRightB.getCurrentPosition());

        waitForStart();
        telemetry.addData("Autonomous.RunOpMode() (opModeIsActive=.", opModeIsActive());

        while (opModeIsActive())
        {
            motorLeftB.setPower(0.9);
            motorRightB.setPower(0.9);
            // need to add front motors, after swapping in front motors with encoders

            telemetry.addData("Autonomous.RunOpMode() (opModeIsActive=.", opModeIsActive());
            telemetry.addData("Left Position", motorLeftB.getCurrentPosition());
            telemetry.addData("Right Position", motorRightB.getCurrentPosition());

            waitOneFullHardwareCycle();
        }

        telemetry.addData("Autonomous.RunOpMode() exiting: (opModeIsActive=.", opModeIsActive());


    }


        // 1. Place robot in starting position

        // 2. go forward x rotations
        // 3. if red, rotate 90 counterclockwise
        // else, rotate 90 clockwise
        // 4. go forward y rotations

}