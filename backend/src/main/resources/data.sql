--default password for all users: "test"
INSERT INTO user (username, password, role) VALUES ('admin', '$2a$10$321OR6dCTtPnEb53sjz3YeCw2KmSee5zDlTJVrp8CjoEMPtbcG3dG', 'ADMIN');
INSERT INTO user (username, password, role) VALUES ('reviewer', '$2a$10$4OntNiI5TtsNc1Lcm0CTyeajtSQKbB2WHej8WEocsBtv8Zwr5x522','REVIEWER');
INSERT INTO user (username, password, role) VALUES ('user', '$2a$10$Lex6XqTYVNYjD1syXlxaNeZCnlpbNi4CHXjcBstiT7XohFyI0laFq', 'USER');