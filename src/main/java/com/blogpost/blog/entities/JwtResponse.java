package com.blogpost.blog.entities;

public class JwtResponse {
    private String jwtToken;
    private String username;
    private String roleType;
    private String userId;
    private String company;
    private String groupName; // Changed to lowercase for consistency
    private String branch;
    private String department;
    private String scope;
    private String engineer;

    public JwtResponse(String jwtToken, String username, String roleType, String userId, String company,
                       String groupName, String branch, String department, String scope, String engineer) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.roleType = roleType;
        this.userId = userId;
        this.company = company;
        this.groupName = groupName; // Changed to lowercase for consistency
        this.branch = branch;
        this.department = department;
        this.scope = scope;
        this.engineer = engineer;
    }

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getGroupName() { return groupName; } // Changed to lowercase for consistency
    public void setGroupName(String groupName) { this.groupName = groupName; } // Changed to lowercase

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getScope() { return scope; }
    public void setScope(String scope) { this.scope = scope; }

    public String getEngineer() { return engineer; }
    public void setEngineer(String engineer) { this.engineer = engineer; }

    public void setJwtToken(String jwtToken) { this.jwtToken = jwtToken; }
    public void setUsername(String username) { this.username = username; }
    public void setRoleType(String roleType) { this.roleType = roleType; }

    public String getJwtToken() { return jwtToken; }
    public String getUsername() { return username; }
    public String getRoleType() { return roleType; }

    public static JwtResponseBuilder builder() {
        return new JwtResponseBuilder();
    }

    public static class JwtResponseBuilder {
        private String jwtToken;
        private String username;
        private String roleType;
        private String userId;
        private String company;
        private String groupName; // Changed to lowercase
        private String branch;
        private String department;
        private String scope;
        private String engineer;

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

        public JwtResponseBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public JwtResponseBuilder company(String company) {
            this.company = company;
            return this;
        }

        public JwtResponseBuilder groupName(String groupName) { // Changed to lowercase
            this.groupName = groupName;
            return this;
        }

        public JwtResponseBuilder branch(String branch) {
            this.branch = branch;
            return this;
        }

        public JwtResponseBuilder department(String department) {
            this.department = department;
            return this;
        }

        public JwtResponseBuilder scope(String scope) {
            this.scope = scope;
            return this;
        }

        public JwtResponseBuilder engineer(String engineer) {
            this.engineer = engineer;
            return this;
        }

        public JwtResponse build() {
            return new JwtResponse(jwtToken, username, roleType, userId, company, groupName, branch, department, scope, engineer);
        }

        @Override
        public String toString() {
            return "JwtResponseBuilder [jwtToken=" + jwtToken + ", username=" + username + ", roleType=" + roleType
                    + ", userId=" + userId + ", company=" + company + ", groupName=" + groupName + ", branch=" + branch
                    + ", department=" + department + ", scope=" + scope + ", engineer=" + engineer + "]";
        }
    }
}
