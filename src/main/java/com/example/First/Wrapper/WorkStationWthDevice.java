package com.example.First.Wrapper;

import com.example.First.ClassEntity.WorkStation;
import com.example.First.ClassEntity.externalDevice;

import javax.validation.Valid;
import java.util.List;

public class WorkStationWthDevice {
    private WorkStation workStation;
    private List<externalDevice> externaldevice;

    public WorkStation getWorkStation() {
        return workStation;
    }

    public void setWorkStation(WorkStation workStation) {
        this.workStation = workStation;
    }

    public List<externalDevice> getExternaldevice() {
        return externaldevice;
    }

    public void setExternaldevice(List<externalDevice> externaldevice) {
        this.externaldevice = externaldevice;
    }
}
