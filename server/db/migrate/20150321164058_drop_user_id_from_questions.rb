class DropUserIdFromQuestions < ActiveRecord::Migration
  def change
	  remove_column :questions, :user_id_id, :text
  end
end

