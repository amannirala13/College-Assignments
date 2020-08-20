
% State vectors
o = [1;0];
i = [0;1];

% Back-up Quantum Gates
% backup_H = 1/sqrt(2)*[1 1; 1 -1];
% backup_CX = [1 0 0 0; 0 1 0 0; 0 0 0 1; 0 0 1 0];
% backup_X = [0 1; 1 0];


%_____________________________________________
% Derivation of H-gate
%_____________________________________________

% H = 1/root(2) * |0><0| + |0><1| + |1><0| - |1><1|
H = 1/sqrt(2)*((o*o')+(o*i')+(i*o')-(i*i'));



%_____________________________________________
% Derivation of CNOT or CX gate
%_____________________________________________

% First we will create the 2 QUBIT states
    % s1 = |00> , s2 = |01> , s3 = |10> , s4 = |11>
s1 = o*o';
s2 = o*i';
s3 = i*o';
s4 = i*i';

    %We need to convert them to column vectors
    s1 = s1';
    s1 = s1(:);

    s2 = s2';
    s2 = s2(:);

    s3 = s3';
    s3 = s3(:);

    s4 = s4';
    s4 = s4(:);
    
% CX = |00><00| + |01><01| + |10><11| + |11><10|
CX = (s1*s1')+(s2*s2')+(s3*s4')+(s4*s3');



%_____________________________________________
%Lets test our gates
%_____________________________________________


%Testing Hadamard Gates
%_____________________________________________

sups_o = H*o;
sups_i = H*i;


%Testing CX gate
%_____________________________________________

%For that we will have to make 2 qubit system. Lets make 2 QUBITS
q1 = o;
q2 = o;

%We will apply H to q1 to see entanglement properly
q1 = H*q1;

%We need to make a 2 qubit system by preforming an uuter product on q1 and
%q2
q12 = q1*q2';

%We need to transform q12 to a column vector so that we can apply CX
%transformation
q12 = q12';
q12 = q12(:);

%Applying CX gate
ent_output = CX*q12;

