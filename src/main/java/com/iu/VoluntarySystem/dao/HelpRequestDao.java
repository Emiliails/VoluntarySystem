package com.iu.VoluntarySystem.dao;

import com.iu.VoluntarySystem.common.DbObject;
import com.iu.VoluntarySystem.entity.HelpRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HelpRequestDao {

    public void addHelpRequest(HelpRequest helpRequest) {
        Connection cn;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
            String sql = "insert into helpRequest (helpRequestCreateTime,helpRequestLocation,helpRequestContent,helpSeekerId) values (?,?,?,?)";
            st = cn.prepareStatement(sql);

            st.setString(1, helpRequest.getHelpRequestCreateTime());
            st.setString(2, helpRequest.getHelpRequestLocation());
            st.setString(3, helpRequest.getHelpRequestContent());
            st.setInt(4, helpRequest.getHelpSeekerId());

            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
    }

    public List<HelpRequest> findByHelpSeekerId(int helpSeekerId) {
        ArrayList<HelpRequest> helpRequests = new ArrayList<>();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from helpRequest where helpSeekerId=?";
            st = cn.prepareStatement(sql);

            st.setInt(1, helpSeekerId);
            System.out.println(st);

            rs = st.executeQuery();
            while (rs.next()) {
                HelpRequest helpRequest = new HelpRequest();
                helpRequest.setHelpRequestId(rs.getInt("helpRequestId"));
                helpRequest.setHelpSeekerId(rs.getInt("helpSeekerId"));
                helpRequest.setHelpRequestCreateTime(rs.getString("helpRequestCreateTime"));
                helpRequest.setHelpRequestLocation(rs.getString("helpRequestLocation"));
                helpRequest.setHelpRequestContent(rs.getString("helpRequestContent"));
                helpRequest.setVolunteerTeamId(rs.getInt("volunteerTeamId"));

                helpRequests.add(helpRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }
        return helpRequests;
    }

    public void volunteerTeamSelectHelpRequest(int volunteerTeamId, int helpRequestId) {
        Connection cn;
        PreparedStatement st = null;

        cn = DbObject.getConnection();

        try {
//            String sql = "insert into helpRequest (helpRequestCreateTime,helpRequestLocation,helpRequestContent,helpSeekerId) values (?,?,?,?)";
            String sql = "update helpRequest set volunteerTeamId=? where helpRequestId=?";
            st = cn.prepareStatement(sql);

            st.setInt(1,volunteerTeamId);
            st.setInt(2,helpRequestId);

            int ret = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, null);
        }
    }

    public List<HelpRequest> findAll() {
        ArrayList<HelpRequest> helpRequests = new ArrayList<>();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from helpRequest";
            st = cn.prepareStatement(sql);

            System.out.println(st);

            rs = st.executeQuery();
            while (rs.next()) {
                HelpRequest helpRequest = new HelpRequest();
                helpRequest.setHelpRequestId(rs.getInt("helpRequestId"));
                helpRequest.setHelpSeekerId(rs.getInt("helpSeekerId"));
                helpRequest.setHelpRequestCreateTime(rs.getString("helpRequestCreateTime"));
                helpRequest.setHelpRequestLocation(rs.getString("helpRequestLocation"));
                helpRequest.setHelpRequestContent(rs.getString("helpRequestContent"));
                helpRequest.setVolunteerTeamId(rs.getInt("volunteerTeamId"));

                helpRequests.add(helpRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }
        return helpRequests;
    }

    public List<HelpRequest> findSelectableHelpRequest() {
        ArrayList<HelpRequest> helpRequests = new ArrayList<>();
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        cn = DbObject.getConnection();
        if (cn == null)
            return null;
        try {
            //4.执行sql
            String sql = "select * from helpRequest where volunteerTeamId is null ";
            st = cn.prepareStatement(sql);

            System.out.println(st);

            rs = st.executeQuery();
            while (rs.next()) {
                HelpRequest helpRequest = new HelpRequest();
                helpRequest.setHelpRequestId(rs.getInt("helpRequestId"));
                helpRequest.setHelpSeekerId(rs.getInt("helpSeekerId"));
                helpRequest.setHelpRequestCreateTime(rs.getString("helpRequestCreateTime"));
                helpRequest.setHelpRequestLocation(rs.getString("helpRequestLocation"));
                helpRequest.setHelpRequestContent(rs.getString("helpRequestContent"));
                helpRequest.setVolunteerTeamId(rs.getInt("volunteerTeamId"));

                helpRequests.add(helpRequest);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //5.关闭数据库连接
            DbObject.close(cn, st, rs);
        }
        return helpRequests;
    }
}
