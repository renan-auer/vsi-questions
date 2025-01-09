String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
try (PreparedStatement stmt = connection.prepareStatement(sql)) {
    stmt.setString(1, username);
    stmt.setString(2, password);
    ResultSet rs = stmt.executeQuery();
}
