CREATE TABLE IF NOT EXISTS operation_assignment_third_party_information (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  assignment_id BIGINT NOT NULL,
  guarantor_name VARCHAR(255) NULL,
  guarantor_identity_number VARCHAR(255) NULL,
  guarantor_address VARCHAR(255) NULL,
  active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_user VARCHAR(255) DEFAULT 'system',
  updated_date TIMESTAMP NULL,
  updated_user VARCHAR(255),
  CONSTRAINT fk_operation_assignment_third_party_information_operation_assignment_assignment_id FOREIGN KEY (assignment_id) REFERENCES operation_assignment (id)
);
