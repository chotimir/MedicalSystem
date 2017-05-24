package com.medicalsystem;

import com.medicalsystem.model.*;
import com.medicalsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final OperationTypeService operationTypeService;
    private final AnesthesiaService anesthesiaService;
    private final AnestheticService anestheticService;
    private final OperationModeService operationModeService;
    private final SmokingService smokingService;
    private final DiseaseService diseaseService;
    private final DiseaseDescriptionService diseaseDescriptionService;
    private final ExaminationDescriptionService examinationDescriptionService;
    private final MedicamentService medicamentService;
    private final ComplicationService complicationService;
    private final ComplicationDescriptionService complicationDescriptionService;

    @Autowired
    public DataLoader(OperationTypeService operationTypeService, AnesthesiaService anesthesiaService, AnestheticService anestheticService, OperationModeService operationModeService, SmokingService smokingService, DiseaseService diseaseService, DiseaseDescriptionService diseaseDescriptionService, ExaminationDescriptionService examinationDescriptionService, MedicamentService medicamentService, ComplicationService complicationService, ComplicationDescriptionService complicationDescriptionService) {
        this.operationTypeService = operationTypeService;
        this.anesthesiaService = anesthesiaService;
        this.anestheticService = anestheticService;
        this.operationModeService = operationModeService;
        this.smokingService = smokingService;
        this.diseaseService = diseaseService;
        this.diseaseDescriptionService = diseaseDescriptionService;
        this.examinationDescriptionService = examinationDescriptionService;
        this.medicamentService = medicamentService;
        this.complicationService = complicationService;
        this.complicationDescriptionService = complicationDescriptionService;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        // rodzaj_zabiegu_s
        operationTypeService.saveOrUpdate(new OperationType(1, "Otwarta operacja wycięcia tętniaka aorty brzusznej"));
        operationTypeService.saveOrUpdate(new OperationType(2, "Endowaskularne zaopatrzenie tętniaka aorty (EVAR)"));
        operationTypeService.saveOrUpdate(new OperationType(3, "Przęsło aortalno dwuudowe (ABF)"));
        operationTypeService.saveOrUpdate(new OperationType(4, "Przęsło aortalno-udowe"));
        operationTypeService.saveOrUpdate(new OperationType(5, "Przęsło aortalno-biodrowe"));
        operationTypeService.saveOrUpdate(new OperationType(6, "Przęsło aortalno-dwubiodrowe"));
        operationTypeService.saveOrUpdate(new OperationType(7, "Plastyka aorty"));


        // znieczulenie_s
        anesthesiaService.saveOrUpdate(new Anesthesia(1, "Ogólne"));
        anesthesiaService.saveOrUpdate(new Anesthesia(2, "Miejscowe"));
        anesthesiaService.saveOrUpdate(new Anesthesia(3, "Podpajęczynówkowe"));
        anesthesiaService.saveOrUpdate(new Anesthesia(4, "Ogólne plus zewnątrzoponowe"));
        anesthesiaService.saveOrUpdate(new Anesthesia(5, "Ogólne plus podpajęczynówkowe"));


        // lek_znieczulajacy_s
        anestheticService.saveOrUpdate(new Anesthetic(1, "Propofol"));
        anestheticService.saveOrUpdate(new Anesthetic(2, "Etomidat"));
        anestheticService.saveOrUpdate(new Anesthetic(3, "Tiopental"));
        anestheticService.saveOrUpdate(new Anesthetic(4, "Ketamina"));
        anestheticService.saveOrUpdate(new Anesthetic(5, "brak danych/nic"));


        // tryb_zabiegu_s
        operationModeService.saveOrUpdate(new OperationMode(1, "Planowy"));
        operationModeService.saveOrUpdate(new OperationMode(2, "Pilny/Naglący"));


        // palenie_tytoniu_s
        smokingService.saveOrUpdate(new Smoking(0, "nie palący"));
        smokingService.saveOrUpdate(new Smoking(1, "palący"));
        smokingService.saveOrUpdate(new Smoking(2, "palący w przeszłości"));


        // choroby_s
        Disease[] diseases = {
                new Disease(1, "HT"),
                new Disease(2, "CAD"),
                new Disease(3, "CAD wysokiego ryzyka"),
                new Disease(4, "MI/ACS przebyty"),
                new Disease(5, "Stenoza aortalna"),
                new Disease(6, "CVE przebyty"),
                new Disease(7, "CHF"),
                new Disease(8, "DM"),
                new Disease(9, "COPD"),
                new Disease(10, "EKG przymęciowe")
        };

        for (Disease disease : diseases) {
            diseaseService.saveOrUpdate(disease);
        }


        // opis_choroby_s
        // HT
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(1, diseases[0], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(2, diseases[0], "tak"));
        // CAD
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(3, diseases[1], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(4, diseases[1], "tak"));
        // CAD wysokiego ryzyka
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(5, diseases[2], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(6, diseases[2], "tak"));
        // MI/ACS
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(7, diseases[3], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(8, diseases[3], "tak"));
        // Stenoza aortalna
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(9, diseases[4], "brak"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(10, diseases[4], "łagodna"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(11, diseases[4], "umiarkowana"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(12, diseases[4], "ciężka"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(13, diseases[4], "sztuczna zastawka"));
        // CVE przebyty
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(14, diseases[5], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(15, diseases[5], "tak"));
        // CHF
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(16, diseases[6], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(17, diseases[6], "tak"));
        // DM
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(18, diseases[7], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(19, diseases[7], "tak"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(20, diseases[7], "w trakcie insulinoterapii"));
        // COPD
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(21, diseases[8], "nie"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(22, diseases[8], "tak"));
        // EKG
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(23, diseases[9], "rytm zatokowy"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(24, diseases[9], "AF"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(25, diseases[9], "rytm zatokowy + obecność VE"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(26, diseases[9], "AF + obecność VE"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(27, diseases[9], "rytm z rozrusznika"));
        diseaseDescriptionService.saveOrUpdate(new DiseaseDescription(28, diseases[9], "AF + rytm z rozrusznika"));


        // badania_s
        examinationDescriptionService.saveOrUpdate(new ExaminationDescription(1, "PShN w stadium 5 (dializoterapia)", "brak"));
        examinationDescriptionService.saveOrUpdate(new ExaminationDescription(2, "Kreatynina", "umol/l"));
        examinationDescriptionService.saveOrUpdate(new ExaminationDescription(3, "eGFR", "MDRD"));
        examinationDescriptionService.saveOrUpdate(new ExaminationDescription(4, "Hb", "g/dl"));
        examinationDescriptionService.saveOrUpdate(new ExaminationDescription(5, "WBC", "tys/ul"));
        examinationDescriptionService.saveOrUpdate(new ExaminationDescription(6, "fibrynogen", "g/l"));


        // leki_s
        medicamentService.saveOrUpdate(new Medicament(1, "Aspiryna"));
        medicamentService.saveOrUpdate(new Medicament(2, "Statyna"));
        medicamentService.saveOrUpdate(new Medicament(3, "ACE-I"));
        medicamentService.saveOrUpdate(new Medicament(4, "ARB"));
        medicamentService.saveOrUpdate(new Medicament(5, "β-bloker"));
        medicamentService.saveOrUpdate(new Medicament(6, "Ca-bloker"));
        medicamentService.saveOrUpdate(new Medicament(7, "werapamil, dilitiazem"));
        medicamentService.saveOrUpdate(new Medicament(8, "Diuretyk"));
        medicamentService.saveOrUpdate(new Medicament(9, "Doustne antykoagulanty"));
        medicamentService.saveOrUpdate(new Medicament(10, "HDCz"));
        medicamentService.saveOrUpdate(new Medicament(11, "klopidogrel"));
        medicamentService.saveOrUpdate(new Medicament(12, "fibrat"));


        // powiklania_s
        Complication[] complications = {
                new Complication(1, "MINS"),
                new Complication(2, "MI"),
                new Complication(3, "Zmiany w EKG"),
                new Complication(4, "Nowe zaburzenia kurczliwości w ECHO"),
                new Complication(5, "Dolegliwości stenodardialne"),
                new Complication(6, "Obrzęk płuc"),
                new Complication(7, "Nowy epizod AF"),
                new Complication(8, "Udar mózgu"),
                new Complication(9, "Zapalenie płuc"),
                new Complication(10, "Sepsa"),
                new Complication(11, "Pooperacyjna niewydolnośc nerek(AKI)"),
                new Complication(12, "Leczenie nerkozastępcze"),
                new Complication(13, "Krwawienie z pp"),
                new Complication(14, "Krwawienie z rany pooperacyjnej"),
                new Complication(15, "Przetoczenie KKCz na OIT/naczyniówce"),
                new Complication(16, "Zatorowość płucna"),
                new Complication(17, "DVT"),
                new Complication(18, "Zakrzepica żył powierzchownych"),
                new Complication(19, "Niedokrwienie jelit"),
                new Complication(20, "Zakażenie miejsca operowanego"),
                new Complication(21, "Niedokrwienie kończyn dolnych"),
                new Complication(22, "Uszkodzenie wątroby"),
                new Complication(23, "Ostre zapalenie trzustki"),
                new Complication(24, "Niedrożność protezy"),
                new Complication(25, "Zakażenie C. difficile"),
                new Complication(26, "Niewydolnosć wielonarządowa"),
                new Complication(27, "Zatrzymanie krążenia nie zakończone zgonem"),
                new Complication(28, "Zgon wewnątrzszpitalny"),
                new Complication(29, "Zgon-doba po operacji"),
                new Complication(30, "Zgon z przyczyn naczyniowych")
        };

        for (Complication complication : complications) {
            complicationService.saveOrUpdate(complication);
        }


        // opis_powiklania_s
        // MINS
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(1, complications[0], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(2, complications[0], "tak"));
        // MI
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(3, complications[1], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(4, complications[1], "NSTEMI ACS"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(5, complications[1], "STEMI"));
        // Zmiany w EKG
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(6, complications[2], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(7, complications[2], "tak"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(8, complications[2], "nie wykonywano badania"));
        // Nowe zaburzenia kurczliwosci
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(9, complications[3], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(10, complications[3], "tak"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(11, complications[3], "nie wykonywano badania"));
        // dolegliwosci stenokardialne
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(12, complications[4], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(13, complications[4], "tak"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(14, complications[4], "brak danych (pacjent nieprzytomny)"));
        // obrzek pluc
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(15, complications[5], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(16, complications[5], "tak"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(17, complications[5], "brak danych (pacjent nieprzytomny)"));
        // Nowy epizod AF
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(18, complications[6], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(19, complications[6], "tak"));
        // Udar mozgu
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(20, complications[7], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(21, complications[7], "tak"));
        // Zapalenie pluc
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(22, complications[8], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(23, complications[8], "tak"));
        // Sepsa
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(24, complications[9], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(25, complications[9], "tak"));
        // Pooperacyjna niewydolnośc nerek(AKI)
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(26, complications[10], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(27, complications[10], "tak"));
        // Leczenie nerkozastępcze
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(28, complications[11], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(29, complications[11], "tak"));
        // Krwawienie z pp
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(30, complications[12], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(31, complications[12], "tak"));
        // Krwawienie z rany pooperacyjnej
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(32, complications[13], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(33, complications[13], "tak"));
        // Przetoczenie KKCz na OIT/naczyniówce
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(34, complications[14], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(35, complications[14], "tak"));
        // Zatorowość płucna
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(36, complications[15], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(37, complications[15], "tak"));
        // DVT
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(38, complications[16], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(39, complications[16], "tak"));
        // Zakrzepica żył powierzchownych
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(40, complications[17], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(41, complications[17], "tak"));
        // Niedokrwienie jelit
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(42, complications[18], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(43, complications[18], "tak"));
        // Zakażenie miejsca operowanego
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(44, complications[19], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(45, complications[19], "tak"));
        // Niedrożność protezy
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(46, complications[20], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(47, complications[20], "tak"));
        // Uszkodzenie watroby
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(48, complications[21], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(49, complications[21], "tak"));
        // Ostre zapalenie trzustki
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(50, complications[22], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(51, complications[22], "tak"));
        // Zakażenie C. difficile
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(52, complications[23], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(53, complications[23], "tak"));
        // Niedokrwienie kończyn dolnych
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(54, complications[24], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(55, complications[24], "tak"));
        // Niewydolność wielonarządowa
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(56, complications[25], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(57, complications[25], "tak"));
        // Zatrzymanie krążenia nie zakończone zgonem
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(58, complications[26], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(59, complications[26], "tak"));
        // Zgon wewnątrzszpitalny
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(60, complications[27], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(61, complications[27], "tak"));
        // Zgon-doba po operacji
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(62, complications[28], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(63, complications[28], "tak"));
        // Zgon z przyczyn naczyniowych
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(64, complications[29], "nie"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(65, complications[29], "tak"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(66, complications[29], "brak danych"));
        complicationDescriptionService.saveOrUpdate(new ComplicationDescription(67, complications[29], "nie dotyczy"));
    }
}