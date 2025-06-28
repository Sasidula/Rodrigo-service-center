package rodrigoservicecenter.controller;

import rodrigoservicecenter.model.AppointmentModel;
import rodrigoservicecenter.model.ServiceModel;
import rodrigoservicecenter.model.ServiceRecordModel;
import rodrigoservicecenter.model.entity.Appointment;
import rodrigoservicecenter.model.entity.Service;
import rodrigoservicecenter.model.entity.ServiceRecord;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class AppointmentController{

    public boolean addAppointment(Appointment appointment){
        AppointmentModel appointmentModel = new AppointmentModel();
        return appointmentModel.createAppointment(appointment);
    }

    public boolean updateAppointment(Appointment appointment){
        AppointmentModel appointmentModel = new AppointmentModel();
        return appointmentModel.updateAppointment(appointment);
    }

    public boolean deleteAppointment(int appointmentId){
        AppointmentModel appointmentModel = new AppointmentModel();
        return appointmentModel.deleteAppointment(appointmentId);
    }

    public Appointment getAppointmentById(int appointmentId){
        AppointmentModel appointmentModel = new AppointmentModel();
        return appointmentModel.getAppointmentById(appointmentId);
    }

    public List<Appointment> getAllAppointments(){
        AppointmentModel appointmentModel = new AppointmentModel();
        return appointmentModel.getAllAppointments();
    }

    public List<Appointment> searchAppointments(Date date, Time time, Integer outletId){
        AppointmentModel appointmentModel = new AppointmentModel();
        return appointmentModel.searchAppointments(date, time, outletId);
    }

    public List<Appointment> getupcomingAppointments(){
        AppointmentModel appointmentModel = new AppointmentModel();
        return appointmentModel.getUpcomingAppointments();
    }

    public Service getServiceById(int serviceId){
        ServiceModel serviceModel = new ServiceModel();
        return serviceModel.getServiceById(serviceId);
    }

    public boolean createServiceRecord(ServiceRecord record){
        ServiceRecordModel serviceRecordModel = new ServiceRecordModel();
        return serviceRecordModel.createServiceRecord(record);
    }

}
