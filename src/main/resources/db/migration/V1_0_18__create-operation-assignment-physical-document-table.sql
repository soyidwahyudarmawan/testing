CREATE TABLE IF NOT EXISTS operation_assignment_physical_document (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  assignment_id BIGINT NOT NULL,
  vehicle_ownership_valid BOOLEAN DEFAULT FALSE,
  tax_notice_valid BOOLEAN DEFAULT FALSE,
  vehicle_registration_valid BOOLEAN DEFAULT FALSE,
  active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_user VARCHAR(255) DEFAULT 'system',
  updated_date TIMESTAMP NULL,
  updated_user VARCHAR(255),
  CONSTRAINT fk_operation_assignment_physical_document_operation_assignment_assignment_id FOREIGN KEY (assignment_id) REFERENCES operation_assignment (id)
);