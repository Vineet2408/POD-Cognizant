INSERT INTO patient_detail (age, ailment, name, treatment_Commencement_Date, treatment_Package) 
VALUES (32, 'Orthopaedics', 'Monica Geller',  TO_DATE('05-03-2021','dd-MM-yyyy'), 'package1');
INSERT INTO patient_detail (age, ailment, name, treatment_Commencement_Date, treatment_Package) 
VALUES (23, 'Urology', 'Sheldon Cooper',  TO_DATE('14/01/2021','dd-MM-yyyy'), 'package2');
INSERT INTO treatment_plan (COST, PACKAGE_NAME, SPECIALIST, TEST_DETAIL, STATUS,	TREATMENT_COMMENCEMENT_DATE, TREATMENT_END_DATE, TP_PT_ID )
VALUES (2500, 'package1', 'Junior Specialist', 'OPT1, OPT2','In Progress', TO_DATE('22-02-2021','dd-MM-yyyy'), TO_DATE('01-04-2021','dd-MM-yyyy'), 1);
INSERT INTO treatment_plan (COST, PACKAGE_NAME, SPECIALIST, TEST_DETAIL, STATUS,	TREATMENT_COMMENCEMENT_DATE, TREATMENT_END_DATE, TP_PT_ID )
VALUES (5000, 'package2', 'Senior Specialist', 'UPT3, UPT4','Completed', TO_DATE('14/01/2021','dd-MM-yyyy'), TO_DATE('24-02-2021','dd-MM-yyyy'), 2);