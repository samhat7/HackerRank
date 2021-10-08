import org.bson.types.ObjectId;

public class Patient {
    //regForm variables

    public String name;
    public String address;
    public String city;
    public String state;
    public String phone;
    public String emergencyContactName;
    public String emergencyContactNumber;
    public String insuranceProvider;
    public String insuranceID;
    public String primaryPhysician;
    public String medicationName;
    public String medicalHistory;
    public String symptoms;
    public String dateOfBirth;
    public String dateOfVisit;


    // patient variable
    public String patientID;

    //medForm variables
    public float height;
    public float weight;
    public float temperature;
    public String bloodPressure;
    public String pulseRate;
    public String assignedPhysician;
    public Boolean isAdmit;

    //notes variable
    public String notes;

    //medication variable
    public int pain;
    public int anticoagulant;
    public int antiretroviral;
    public int betaBlocker;
    public int insulin;
    public int antiInflammatory;
    public int ursodiol;
    public int calciumReducer;

    //test variable
    public Boolean nucleicAcid = false;
    public Boolean coagulationPanel = false;
    public Boolean dheaSulfateSerum = false;
    public Boolean cReactiveProtein = false;
    public Boolean alc = false;
    public Boolean xray = false;
    public Boolean ctScan = false;
    public Boolean mri = false;
    public Boolean urinalysis = false;
    public Boolean stoolCultures = false;

    //diagnosis variable
    public Boolean brokenBone = false;
    public Boolean heartAttack = false;
    public Boolean laceration = false;
    public Boolean hivAIDS = false;
    public Boolean liverFailure = false;
    public Boolean kidneyFailure = false;
    public Boolean diabetes = false;
    public Boolean infammatoryBowlDisease = false;
    public Boolean stroke = false;
    public Boolean tornMuscleTendon = false;

    //billing variable
    public int priceTest;
    public int priceMed;
    public int nightsStayed;
    public float totalCost;

    public Patient() {
        Object id = new ObjectId();
        patientID = id.toString();
    }

    public Patient(Patient patientCopy) {
        this.name = patientCopy.getName();
        this.address = patientCopy.getAddress();
        this.city = patientCopy.getCity();
        this.state = patientCopy.getState();
        this.phone = patientCopy.getPhone();
        this.emergencyContactName = patientCopy.getEmergencyContactName();
        this.emergencyContactNumber = patientCopy.getEmergencyContactNumber();
        this.insuranceProvider = patientCopy.getInsuranceProvider();
        this.insuranceID = patientCopy.getInsuranceID();
        this.primaryPhysician = patientCopy.getPrimaryPhysician();
        this.medicationName = patientCopy.getMedicationName();
        this.medicalHistory = patientCopy.getMedicalHistory();
        this.symptoms = patientCopy.getSymptoms();
        this.dateOfBirth = patientCopy.getDateOfBirth();
        this.dateOfVisit = patientCopy.getDateOfVisit();

        this.patientID = patientCopy.getPatientID();

        this.height = patientCopy.getHeight();
        this.weight = patientCopy.getWeight();
        this.temperature = patientCopy.getTemperature();
        this.bloodPressure = patientCopy.getBloodPressure();
        this.pulseRate = patientCopy.getPulseRate();
        this.assignedPhysician = patientCopy.getAssignedPhysician();
        this.isAdmit = patientCopy.getAdmit();

        this.notes = patientCopy.getNotes();

        this.pain = patientCopy.getPain();
        this.anticoagulant = patientCopy.getAnticoagulant();
        this.antiretroviral = patientCopy.getAntiretroviral();
        this.betaBlocker = patientCopy.getBetaBlocker();
        this.insulin = patientCopy.getInsulin();
        this.antiInflammatory = patientCopy.getAntiInflammatory();
        this.ursodiol = patientCopy.getUrsodiol();
        this.calciumReducer = patientCopy.getCalciumReducer();

        this.nucleicAcid = patientCopy.getNucleicAcid();
        this.coagulationPanel = patientCopy.getCoagulationPanel();
        this.dheaSulfateSerum = patientCopy.getDheaSulfateSerum();
        this.cReactiveProtein = patientCopy.getcReactiveProtein();
        this.alc = patientCopy.getAlc();
        this.xray = patientCopy.getXray();
        this.ctScan = patientCopy.getCtScan();
        this.mri = patientCopy.getMri();
        this.urinalysis = patientCopy.getUrinalysis();
        this.stoolCultures = patientCopy.getStoolCultures();

        this.brokenBone = patientCopy.getBrokenBone();
        this.heartAttack = patientCopy.getHeartAttack();
        this.laceration = patientCopy.getLaceration();
        this.hivAIDS = patientCopy.getHivAIDS();
        this.liverFailure = patientCopy.getLiverFailure();
        this.kidneyFailure = patientCopy.getKidneyFailure();
        this.diabetes = patientCopy.getDiabetes();
        this.infammatoryBowlDisease = patientCopy.getInfammatoryBowlDisease();
        this.stroke = patientCopy.getStroke();
        this.tornMuscleTendon = patientCopy.getTornMuscleTendon();

        this.priceTest = patientCopy.getPriceTest();
        this.priceMed = patientCopy.getPriceMed();
        this.nightsStayed = patientCopy.getNightsStayed();
        this.totalCost = patientCopy.getTotal();
    }

    //constructor to initiate every variable in regform. This makes the patient object

    public Patient(String fName, String lName, String address, String city, String state, String phone, String emergencyContactName, String emergencyContactNumber, String insuranceProvider, String insuranceID, String primaryPhysician, String medicationName, String medicalHistory, String symptoms, String dateOfBirth, String dateOfVisit) {
        Object id = new ObjectId();
        patientID = id.toString();

        this.name = fName + " " + lName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNumber = emergencyContactNumber;
        this.insuranceProvider = insuranceProvider;
        this.insuranceID = insuranceID;
        this.primaryPhysician = primaryPhysician;
        this.medicationName = medicationName;
        this.medicalHistory = medicalHistory;
        this.symptoms = symptoms;
        this.dateOfBirth = dateOfBirth;
        this.dateOfVisit = dateOfVisit;
    }

    // this is all the information after.

    public Patient(float height, float weight, float temperature, String bloodPressure, String pulseRate, String assignedPhysician, Boolean isAdmit, int pain, int anticoagulant, int antiretroviral, int betaBlocker, int insulin, int antiInflammatory, int ursodiol, int calciumReducer, Boolean nucleicAcid, Boolean dheaSulfateSerum, Boolean cReactiveProtein, Boolean alc, Boolean xray, Boolean ctScan, Boolean mri, Boolean urinalysis, Boolean stoolCultures, Boolean brokenBone, Boolean heartAttack, Boolean laceration, Boolean hivAIDS, Boolean liverFailure, Boolean kidneyFailure, Boolean diabetes, Boolean infammatoryBowlDisease, Boolean stroke, Boolean tornMuscleTendon, Boolean coagulationPanel) {
        Object id = new ObjectId();
        patientID = id.toString();

        this.height = height;
        this.weight = weight;
        this.temperature = temperature;
        this.bloodPressure = bloodPressure;
        this.pulseRate = pulseRate;
        this.assignedPhysician = assignedPhysician;
        this.isAdmit = isAdmit;
      
        this.pain = pain;
        this.anticoagulant = anticoagulant;
        this.antiretroviral = antiretroviral;
        this.betaBlocker = betaBlocker;
        this.insulin = insulin;
        this.antiInflammatory = antiInflammatory;
        this.ursodiol = ursodiol;
        this.calciumReducer = calciumReducer;

        this.nucleicAcid = nucleicAcid;
        this.coagulationPanel = coagulationPanel;
        this.dheaSulfateSerum = dheaSulfateSerum;
        this.cReactiveProtein = cReactiveProtein;
        this.alc = alc;
        this.xray = xray;
        this.ctScan = ctScan;
        this.mri = mri;
        this.urinalysis = urinalysis;
        this.stoolCultures = stoolCultures;

        this.brokenBone = brokenBone;
        this.heartAttack = heartAttack;
        this.laceration = laceration;
        this.hivAIDS = hivAIDS;
        this.liverFailure = liverFailure;
        this.kidneyFailure = kidneyFailure;
        this.diabetes = diabetes;
        this.infammatoryBowlDisease = infammatoryBowlDisease;
        this.stroke = stroke;
        this.tornMuscleTendon = tornMuscleTendon;
    }

    //regForm
    //get and set Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //get and set City
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //get and set State
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //get and set DOB
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //get and set DateOfVisit
    public String getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    //Get and set EmergencyContactNumber
    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    //get and set Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //get and set EmergencyContactName
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    //get and set insuranceID
    public String getInsuranceID() {
        return insuranceID;
    }

    public void setInsuranceID(String insuranceID) {
        this.insuranceID = insuranceID;
    }

    //get and set insuranceProvider
    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    //get and set name
    public String getName() {
        return name;
    }

    public void setName(String fname, String lname) {
        this.name = fname + " " + lname;
    }

    //get and set primary Physician
    public String getPrimaryPhysician() {
        return primaryPhysician;
    }

    public void setPrimaryPhysician(String primaryPhysician) {
        this.primaryPhysician = primaryPhysician;
    }

    //get and set medicalHistory
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    //get and set medicationName
    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    //get and set symptoms
    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    //patient
    //get and set patientID
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    //medForm
    //get and set admit
    public Boolean getAdmit() {
        return isAdmit;
    }

    public void setAdmit(Boolean admit) {
        isAdmit = admit;
    }

    //get and set height
    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    //get and set temperature
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    //get and set weight
    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    //get and set assignedPhysician
    public String getAssignedPhysician() {
        return assignedPhysician;
    }

    public void setAssignedPhysician(String assignedPhysician) {
        this.assignedPhysician = assignedPhysician;
    }

    //get and set bloodPressure
    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    //get and set pulseRate
    public String getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(String pulseRate) {
        this.pulseRate = pulseRate;
    }

    //notes
    //get and set notes
    public String getNotes() {
        return notes;
    }

    public void setNotes(String content) {
        notes = content;
    }

    //medication
    //get and set pain
    public int getPain() {
        return pain;
    }

    public void setPain(int pain) {
        this.pain = pain;
    }

    //get and set anticoagulant
    public int getAnticoagulant() {
        return anticoagulant;
    }

    public void setAnticoagulant(int anticoagulant) {
        this.anticoagulant = anticoagulant ;
    }

    //get and set antiretroviral
    public int getAntiretroviral() {
        return antiretroviral;
    }

    public void setAntiretroviral(int antiretroviral) {
        this.antiretroviral = antiretroviral;
    }

    //get and set betaBlocker
    public int getBetaBlocker() {
        return betaBlocker;
    }

    public void setBetaBlocker(int betaBlocker) {
        this.betaBlocker = betaBlocker;
    }

    //get and set insulin
    public int getInsulin() {
        return insulin;
    }

    public void setInsulin(int insulin) {
        this.insulin = insulin;
    }

    //get and set antiInflammartory
    public int getAntiInflammatory() {
        return antiInflammatory;
    }

    public void setAntiInflammatory(int antiInflammatory) {
        this.antiInflammatory = antiInflammatory;
    }

    //get and set ursodial
    public int getUrsodiol() {
        return ursodiol;
    }

    public void setUrsodiol(int ursodiol) {
        this.ursodiol = ursodiol;
    }

    //get and set calciumReducer
    public int getCalciumReducer() {
        return calciumReducer;
    }

    public void setCalciumReducer(int calciumReducer) {
        this.calciumReducer = calciumReducer;
    }

    //Test
    //get and set nucleicAcid
    public Boolean getNucleicAcid() {
        return nucleicAcid;
    }

    public void setNucleicAcid(Boolean nucleicAcid) {
        this.nucleicAcid = nucleicAcid;
    }

    //get and set coagulationPanel
    public Boolean getCoagulationPanel() {
        return coagulationPanel;
    }

    public void setCoagulationPanel(Boolean coagulationPanel) {
        this.coagulationPanel = coagulationPanel;
    }

    //get and set dheaSulfateSerum
    public Boolean getDheaSulfateSerum() {
        return dheaSulfateSerum;
    }

    public void setDheaSulfateSerum(Boolean dheaSulfateSerum) {
        this.dheaSulfateSerum = dheaSulfateSerum;

    }

    //get and set cReactiveProtein
    public Boolean getcReactiveProtein() {
        return cReactiveProtein;
    }

    public void setcReactiveProtein(Boolean cReactiveProtein) {
        this.cReactiveProtein = cReactiveProtein;
    }

    //get and set alc
    public Boolean getAlc() {
        return alc;
    }

    public void setAlc(Boolean alc) {
        this.alc = alc;
    }

    //get and set xray
    public Boolean getXray() {
        return xray;
    }

    public void setXray(Boolean xray) {
        this.xray = xray;
    }

    //get and set ctScan
    public Boolean getCtScan() {
        return ctScan;
    }

    public void setCtScan(Boolean ctScan) {
        this.ctScan = ctScan;
    }

    //get and set mri
    public Boolean getMri() {
        return mri;
    }

    public void setMri(Boolean mri) {
        this.mri = mri;
    }

    //get and set urinalysis
    public Boolean getUrinalysis() {
        return urinalysis;
    }

    public void setUrinalysis(Boolean urinalysis) {
        this.urinalysis = urinalysis;
        if (urinalysis)
            this.priceTest += 21;
    }

    //get and set stoolCultures
    public Boolean getStoolCultures() {
        return stoolCultures;
    }

    public void setStoolCultures(Boolean stoolCultures) {
        this.stoolCultures = stoolCultures;
    }

    //diagnosis
    //get and set brokenBone
    public Boolean getBrokenBone() {
        return brokenBone;
    }

    public void setBrokenBone(Boolean brokenBone) {
        this.brokenBone = brokenBone;
    }

    //get and set heartAttack
    public Boolean getHeartAttack() {
        return heartAttack;
    }

    public void setHeartAttack(Boolean heartAttack) {
        this.heartAttack = heartAttack;
    }

    //get and set laceration
    public Boolean getLaceration() {
        return laceration;
    }

    public void setLaceration(Boolean laceration) {
        this.laceration = laceration;
    }

    //get and set hivAIDS
    public Boolean getHivAIDS() {
        return hivAIDS;
    }

    public void setHivAIDS(Boolean hivAIDS) {
        this.hivAIDS = hivAIDS;
    }

    //get and set liverFailure
    public Boolean getLiverFailure() {
        return liverFailure;
    }

    public void setLiverFailure(Boolean liverFailure) {
        this.liverFailure = liverFailure;
    }

    //get and set kidneyFailure
    public Boolean getKidneyFailure() {
        return kidneyFailure;
    }

    public void setKidneyFailure(Boolean kidneyFailure) {
        this.kidneyFailure = kidneyFailure;
    }

    //get and set diabetes
    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    //get and set inflammatoryBowelDisease
    public Boolean getInfammatoryBowlDisease() {
        return infammatoryBowlDisease;
    }

    public void setInfammatoryBowlDisease(Boolean infammatoryBowlDisease) {
        this.infammatoryBowlDisease = infammatoryBowlDisease;
    }

    //get and set stroke
    public Boolean getStroke() {
        return stroke;
    }

    public void setStroke(Boolean stroke) {
        this.stroke = stroke;
    }

    //get and set tornMuscleTendon
    public Boolean getTornMuscleTendon() {
        return tornMuscleTendon;
    }

    public void setTornMuscleTendon(Boolean tornMuscleTendon) {
        this.tornMuscleTendon = tornMuscleTendon;
    }


    public int getNightsStayed() {
        return nightsStayed;
    }

    public void setNightsStayed(int nights) {
        nightsStayed = nights;
    }

    public int getOvernightCost() {
        return nightsStayed * 30;
    }

    public int getTotal() {
        return priceMed + priceTest + (nightsStayed * 30);
    }

    public int getPriceMed() {
        return priceMed;
    }

    public int getPriceTest() {
        return priceTest;
    }

    public void setPriceMed(int pain, int anticoagulant, int antiretroviral, int betaBlocker, int insulin, int antiInflammatory, int ursodiol, int calciumReducer) {
        this.priceMed = (pain) + (anticoagulant * 2) + (antiretroviral * 3) + (betaBlocker * 4) + (insulin * 5) + (antiInflammatory * 6) + (ursodiol * 7) + (calciumReducer * 8);
    }

    public void calculatePrices() {
        priceMed = (pain) + (anticoagulant * 2) + (antiretroviral * 3) + (betaBlocker * 4) + (insulin * 5) + (antiInflammatory * 6) + (ursodiol * 7) + (calciumReducer * 8);
        if (nucleicAcid)
            priceTest += 13;
        if (coagulationPanel)
            priceTest += 14;
        if (dheaSulfateSerum)
            priceTest += 15;
        if (cReactiveProtein)
            priceTest += 16;
        if (alc)
            priceTest += 17;
        if (xray)
            priceTest += 18;
        if (ctScan)
            priceTest += 19;
        if (mri)
            priceTest += 20;
        if (stoolCultures)
            priceTest += 22;
    }

    public void setPriceTest(int priceTest) {
        this.priceTest = priceTest;
    }
}
