package com.travel.travelAgency.authentication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.travel.travelAgency.authentication.repository.ForgotPasswordRepository;
import com.travel.travelAgency.util.DatabaseConnection;

/**
 * @author sowjanyamani
 */

@Repository
public class ForgotPasswordDAO implements ForgotPasswordRepository {
	Connection con = DatabaseConnection.getSQLConnection();

	@Override
	public Boolean isEmailValid(String email) throws Exception {

		String SQL = "select email_id from user_auth where email_id='" + email + "'";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(SQL);
			ResultSet resultSet = preparedStatement.executeQuery(SQL);
			while (resultSet.next()) {
				return Boolean.TRUE;
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

	@Override
	public String getSecurityQuestion(String email) throws Exception {

		String SQL = "select sq.question from user_auth ua join security_questions sq on ua.security_question_id = sq.question_id where email_id= '"
				+ email + "'";
		String question = "";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SQL);
			ResultSet resultSet = preparedStatement.executeQuery(SQL);
			while (resultSet.next()) {
				question = resultSet.getString("question");
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return question;
	}

	@Override
	public Boolean isSecurityAnswerValid(String security_answer, String email) throws Exception {

		String SQL = "select security_answer from user_auth  where email_id='" + email + "'";
		String answer = "";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(SQL);
			ResultSet resultSet = preparedStatement.executeQuery(SQL);
			while (resultSet.next()) {
				answer = resultSet.getString("security_answer");
				if (!(answer.equalsIgnoreCase(security_answer))) {
					throw new Exception("Check the answer");

				}
				return Boolean.TRUE;
			}

		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

	@Override
	public void updatePassword(String email, String newPassword) throws Exception {

		String SQL = "UPDATE user_auth SET password = '" + newPassword + "' where email_id='" + email + "'";

		try {
			PreparedStatement preparedStatement = con.prepareStatement(SQL);
			preparedStatement.executeUpdate();

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}

}
