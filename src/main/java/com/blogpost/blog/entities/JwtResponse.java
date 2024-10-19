package com.blogpost.blog.entities;



public class JwtResponse {
	private String jwtToken;
	private String username;
	private String roleType;
	private int userId;
 
	private JwtResponse(String jwtToken, String username, String roleType, int userId) {
		this.jwtToken = jwtToken;
		this.username = username;
		this.roleType = roleType;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public String getUsername() {
		return username;
	}

	public String getRoleType() {
		return roleType;
	}

	public static JwtResponseBuilder builder() {
		return new JwtResponseBuilder();
	}

	public static class JwtResponseBuilder {
		private String jwtToken;
		private String username;
		private String roleType;
		private int userId;

		public JwtResponseBuilder jwtToken(String jwtToken) {
			this.jwtToken = jwtToken;
			return this;
		}

		public JwtResponseBuilder username(String username) {
			this.username = username;
			return this;
		}

		public JwtResponseBuilder roleType(String roleType) {
			this.roleType = roleType;
			return this;
		}

		public JwtResponseBuilder userId(int userId) {
			this.userId = userId;
			return this;
		}

		public JwtResponse build() {
			return new JwtResponse(jwtToken, username, roleType, userId);
		}
	}
}
