CREATE TABLE IF NOT EXISTS operation_assignment (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  application_id UUID NOT NULL,
  application_number VARCHAR(255) NOT NULL,
  surveyor_assignment_id BIGINT NOT NULL,
  branch_id BIGINT NOT NULL,
  asset_document_data_completed BOOLEAN DEFAULT FALSE,
  document_sign_completed BOOLEAN DEFAULT FALSE,
  physical_document_completed BOOLEAN DEFAULT FALSE,
  third_party_information_completed BOOLEAN DEFAULT FALSE,
  funding_information_completed BOOLEAN DEFAULT FALSE,
  asset_data_completed BOOLEAN DEFAULT FALSE,
  assignment_status VARCHAR(255) NOT NULL,
  assignment_branch_status VARCHAR(255) NOT NULL,
  assignment_head_office_status VARCHAR(255) NOT NULL,
  branch_pic VARCHAR(255) NULL,
  head_office_cdp_pic VARCHAR(255) NULL,
  head_office_rco_pic VARCHAR(255) NULL,
  active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_user VARCHAR(255) DEFAULT 'system',
  updated_date TIMESTAMP NULL,
  updated_user VARCHAR(255),
  CONSTRAINT fk_operation_assignment_application_application_id FOREIGN KEY (application_id) REFERENCES application (id),
  CONSTRAINT fk_operation_assignment_surveyor_assignment_assignment_id FOREIGN KEY (surveyor_assignment_id) REFERENCES surveyor_assignment (id),
  CONSTRAINT fk_operation_assignment_branch_branch_id FOREIGN KEY (branch_id) REFERENCES branch (id)
);
